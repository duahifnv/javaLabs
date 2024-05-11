package lab7.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class FilterImage extends JLabel {
    private final BufferedImage originalImage;
    private BufferedImage displayedImage;
    private boolean flipped = false;
    public FilterImage(BufferedImage image) {
        this.originalImage = image;
        this.displayedImage = image;
        setFocusable(true);
        requestFocusInWindow();
    }
    public void setFilter(Filter filter) {
        if (originalImage != null) {
            switch (filter) {
                case GRAYSCALE -> displayedImage = convertToGrayScale(originalImage);
                case BLUR -> displayedImage = applyBlur(originalImage);
                case ROTATE -> rotateImage();
            }
        }
        repaint();
    }
    public void resetFilter() {
        displayedImage = originalImage;
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        if (displayedImage != null) {
            int width = getWidth();
            int height = getHeight();
            int imgWidth = displayedImage.getWidth();
            int imgHeight = displayedImage.getHeight();

            int scaledWidth = width;
            int scaledHeight = (int) (imgHeight * ((double) width / imgWidth));

            if (scaledHeight > height) {
                scaledHeight = height;
                scaledWidth = (int) (imgWidth * ((double) height / imgHeight));
            }

            int x = (width - scaledWidth) / 2;
            int y = (height - scaledHeight) / 2;
            g.drawImage(displayedImage, x, y, scaledWidth, scaledHeight, this);
        }
    }
    private void rotateImage() {
        if (originalImage != null) {
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-originalImage.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            displayedImage = op.filter(originalImage, null);
            flipped = !flipped;
        }
    }
    private BufferedImage convertToGrayScale(BufferedImage img) {
        BufferedImage grayImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = grayImg.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return grayImg;
    }
    private BufferedImage applyBlur(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage blurredImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int windowSize = 3;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = getAverageColor(img, x, y, windowSize);
                blurredImg.setRGB(x, y, rgb);
            }
        }

        return blurredImg;
    }
    private int getAverageColor(BufferedImage img, int x, int y, int windowSize) {
        int width = img.getWidth();
        int height = img.getHeight();
        int halfWindowSize = windowSize / 2;

        int sumRed = 0;
        int sumGreen = 0;
        int sumBlue = 0;

        int count = 0;

        for (int dy = -halfWindowSize; dy <= halfWindowSize; dy++) {
            for (int dx = -halfWindowSize; dx <= halfWindowSize; dx++) {
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                    int rgb = img.getRGB(nx, ny);
                    sumRed += (rgb >> 16) & 0xFF;
                    sumGreen += (rgb >> 8) & 0xFF;
                    sumBlue += rgb & 0xFF;
                    count++;
                }
            }
        }

        int avgRed = sumRed / count;
        int avgGreen = sumGreen / count;
        int avgBlue = sumBlue / count;

        return (avgRed << 16) | (avgGreen << 8) | avgBlue;
    }
}