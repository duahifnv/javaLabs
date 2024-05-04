package lab7.task1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Task1 extends JFrame {
    private JComboBox<String> jComboBox = new JComboBox<>();
    private JLabel jLabel = new JLabel();
    private JButton jButton = new JButton("Кнопка");
    private JCheckBox jCheckBox = new JCheckBox();
    private JRadioButton jRadioButton = new JRadioButton();
    private String[] tLabels = {"Язык", "Автор", "Год"};
    private String[][] tData = {{"Си", "Деннис Ритчи", "1972"},
            {"C++", "Бьерн Страуструп", "1983"},
            {"Python", "Гвидо ван Россум", "1991"},
            {"Java", "Джеймс Гослинг", "1995"},
            {"JavaScript", "Брендон Айк", "1995"},
            {"C#", "Андерс Хейлсберг", "2001"},
            {"Scala", "Мартин Одерски", "2003"}};
    private JTable jTable;
    public Task1() {
        super("Task1");
        jLabel.setText("Метка");
        jTable = jTableConfig(tLabels, tData);
        UIManager.LookAndFeelInfo[] lfi = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo item : lfi) {
            jComboBox.addItem(item.getClassName());
        }
        jComboBox.addActionListener(event -> {
            try {
                int index = jComboBox.getSelectedIndex();
                String laf = jComboBox.getItemAt(index);
                UIManager.setLookAndFeel(laf);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);
        jPanel.add(jLabel);
        jPanel.add(jButton);
        jPanel.add(jCheckBox);
        jPanel.add(jRadioButton);
        jPanel.add(jTable);
        add(jPanel);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private static JTable jTableConfig(String[] tLabels, String[][] tData) {
        JTable table = new JTable(new DefaultTableModel(tData, tLabels) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumnModel colModel= table.getColumnModel();
        colModel.getColumn(1).setPreferredWidth(150);
        return table;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task1::new);
    }
}