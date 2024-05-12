package lab7.task4;

import lab7.elements.Button;
import lab7.elements.Label;
import lab7.elements.LabelPanel;
import lab7.task3.TextField;
import lab7.task3.TextPrompt;

import javax.swing.*;

public class IntervalField extends LabelPanel {
    public IntervalField() {
        setLabel("Интервал");
        JTextField fromField = new TextField();
        TextPrompt fromPrompt = new TextPrompt("От", fromField, TextPrompt.Show.FOCUS_LOST);
        add(fromField);

        JTextField toField = new TextField();
        TextPrompt toPrompt = new TextPrompt("До", toField, TextPrompt.Show.FOCUS_LOST);
        add(toField);

        Label errorMsg = new Label("Неверный ввод");
        errorMsg.setVisible(false);
        errorMsg.offsetFontSize(-8);
        add(errorMsg);
        Button submitBtn = new Button();
        submitBtn.setText("Установить");
        submitBtn.addActionListener(e -> {
            try {
                double from = Double.parseDouble(fromField.getText());
                double to = Double.parseDouble(toField.getText());
                if (from > to) throw new NumberFormatException();
                errorMsg.setVisible(false);
                Task4.graph.setInterval(from, to);
            }
            catch (NumberFormatException | NullPointerException ne) {
                errorMsg.setVisible(true);
            }
        });
        add(submitBtn);
    }
}
