package aebTask1;
//Main класс приложения

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AEBTaskApp {
        private JButton button1;
        private JPanel panelMain;
        private JLabel description;
        private JScrollPane scrollPane;
        private JTextArea textArea;

        public static void main(String[] args) throws Exception {
                //Ининциализация приложения
                JFrame frame = new JFrame("AEBTask1App");
                frame.setContentPane(new AEBTaskApp().panelMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        }

        public AEBTaskApp() throws IOException {
                //Инициализация программы
                GoldenNumberDetector goldenNumberDetector = new GoldenNumberDetector();
                description.setText("Программа находит \"золотые\" номера из указанного txt файла");
                scrollPane.setVisible(false);
                textArea.setVisible(false);
                button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                //Инициализация выбора файла при клике на кнопку
                                JFileChooser chooser = new JFileChooser();
                                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                                        "txt файл c номерами", "txt");
                                chooser.setFileFilter(filter);
                                int returnVal = chooser.showOpenDialog(null);
                                if (returnVal == JFileChooser.APPROVE_OPTION) {
                                        try {
                                                //Вывод номеров с использованием логики программы и выборщика файла
                                                writeNumbers(goldenNumberDetector.parseNumbers(chooser.getSelectedFile().getAbsolutePath()));
                                        } catch (IOException ex) {
                                                ex.printStackTrace();
                                        }
                                }
                        }
                });
        }

        private void writeNumbers(List<String> parseNumbers) {
                //Вывод золотых номеров в textArea, сокрытие ненужных элементов
                scrollPane.setVisible(true);
                textArea.setVisible(true);
                button1.setVisible(false);
                description.setVisible(false);
                for (String s : parseNumbers) {
                        textArea.append(s + "\n");
                        //Вывод результата в консоль
                        System.out.println(s);
                }
        }
}
