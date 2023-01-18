import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class WindowApplication extends JFrame{
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    private JLabel label2;
    private JButton button3;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JButton button4;
    private JPanel rootPanel;
    private JTextField textField3;
    private JLabel label5;
    private JFileChooser explorer;

    public WindowApplication() {
        this.setTitle("Task 8.23");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setSize(600, 600);

        createListeners();
    }

    private void createListeners() {
        button4.addActionListener(actionEvent -> {
            try {
                String coordinates = Logic.getCoordinates(getArray());

                FileUtils.printToNonCertainFile(label2.getText(), coordinates);
                textField3.setText(coordinates);

            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
        });

        button3.addActionListener(actionEvent -> {
            try {
              if(textField1.getText() != null && textField2.getText() != null) {
                  int rowCount = Integer.parseInt(textField1.getText());
                  int columnCount = Integer.parseInt(textField2.getText());

                  table1.setModel(new DefaultTableModel(rowCount, columnCount));
              }

            } catch (Exception e) {
                System.out.println("Введите верные значения");
            }
        });

        button2.addActionListener(actionEvent -> {
            for (int i = 0; i < table1.getRowCount(); i++) {
                for (int j = 0; j < table1.getColumnCount(); j++) {
                    table1.setValueAt(null, i, j);;
                }
            }

            label2.setText("Нет");
            textField3.setText(null);
        });

        button1.addActionListener(actionEvent -> {
            explorer = new JFileChooser("InputFiles/");

            File file;
            if(explorer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    file = explorer.getSelectedFile();

                    arrInJTable(FileUtils.readFile(file.getName()));
                    label2.setText(file.getName());

                } catch (FileNotFoundException e) {
                    System.out.println("Что-то не так с файлом");
                }
            }
        });
    }

    private void arrInJTable(int[][] arr) {
        table1.setModel(new DefaultTableModel(arr.length, arr[0].length));

        for (int i = 0; i < table1.getRowCount(); i++) {
            for (int j = 0; j < table1.getColumnCount(); j++) {
                table1.setValueAt(arr[i][j], i, j);
            }
        }
    }

    private int[][] getArray() {
        int[][] arr = new int[table1.getRowCount()][table1.getColumnCount()];

        try {
            for (int i = 0; i < table1.getRowCount(); i++) {
                for (int j = 0; j < table1.getColumnCount(); j++) {
                    arr[i][j] = Integer.parseInt((String) table1.getValueAt(i, j));
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return arr;
    }
}
