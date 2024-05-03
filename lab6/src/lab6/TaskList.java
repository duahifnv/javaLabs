package lab6;

import lab6.task1.SinusApp;
import lab6.task2.Curve;
import lab6.task4.MouseClickApp;
import lab6.task5.DisplayApp;
import lab6.task6.FilterApp;
import lab6.task7.BallAnimationApp;
import lab6.task8.TickerApp;

import javax.swing.*;
public class TaskList {
    private static JFrame newFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        return frame;
    }
    public static void task1() {
        SinusApp.draw(300, 300);
    }
    public static void task2() {
        JFrame frame = newFrame("Кривая", 300, 300);
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < 100; i++) {
            xData[i] = i * 2 * Math.PI / 100;
            yData[i] = Math.sin(xData[i]);
        }
        Curve curve = new Curve();
        curve.setData(xData, yData);
        frame.add(curve);
        frame.setVisible(true);
    }
    public static void task4() {
        JFrame frame = newFrame("Координаты щелчка мыши", 600, 600);
        MouseClickApp mouseClick = new MouseClickApp();
        frame.add(mouseClick);
        frame.setVisible(true);
    }
    public static void task5() {
        JFrame frame = newFrame("Изображение", 600, 600);
        DisplayApp displayApp = new DisplayApp();
        frame.add(displayApp);
        frame.setVisible(true);
    }
    public static void task6() {
        JFrame frame = newFrame("Фильтр", 600, 600);
        FilterApp filterApp = new FilterApp();
        frame.add(filterApp);
        frame.setVisible(true);
    }
    public static void task7() {
        JFrame frame = newFrame("Анимация", 1000, 600);
        BallAnimationApp ballAnimationApp = new BallAnimationApp();
        frame.add(ballAnimationApp);
        frame.setVisible(true);
        ballAnimationApp.startAnimation();
    }
    public static void task8() {
        String[] messages = {"Lorem", "Ipsum", "Vertum"};
        JFrame frame = newFrame("Бегущая строка", 500, 100);
        TickerApp tickerApp = new TickerApp(messages);
        frame.add(tickerApp);
        frame.setVisible(true);
        frame.setResizable(false);
        tickerApp.run();
    }
}
