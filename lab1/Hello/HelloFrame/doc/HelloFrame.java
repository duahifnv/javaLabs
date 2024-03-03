import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * @version 1.0
 * @author MisterX
 */
public class HelloFrame extends Frame {
    /** Programm entry point */
    public static void main(String[] args) throws Exception{
        HelloFrame hello = new HelloFrame();
        hello.setTitle("Hello!");
        hello.setBackground(Color.black);
        hello.setLayout(new FlowLayout());
        hello.setLabelAttributes(firstLabel);
        hello.setLabelAttributes(secondLabel);
        hello.add(firstLabel);
        hello.add(secondLabel);
        hello.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random rnd = new Random();
                int idx = rnd.nextInt(4);
                secondLabel.setText(text[idx]);
            }
        });
        hello.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        hello.setBounds(100,100,260,80);
        hello.setVisible(true);
    }

    /** method that changes Label attributes
     * @param label - concrete Label
     */

    private void setLabelAttributes(Label label) {
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
        label.setFont(font);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.YELLOW);
    }

    /**field - reference array of strings */
    private static String[] text = {"Word", "Lord", "Nord", "Sword"};
    /** field - Label for preamble */
    private static final Label firstLabel = new Label("Hello my");
    /** field - Label for variants of answers */
    private static final Label secondLabel = new Label(text[0]);
}