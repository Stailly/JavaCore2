package hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class hw4 {
    //Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
    // Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели. Сообщение
    // должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter. При «отсылке» сообщение
    // перекидывается из нижнего поля в центральное.
    static class MyWindow extends JFrame {
        JPanel jpN = new JPanel(new GridLayout());
        JPanel jpS = new JPanel(new GridLayout());
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        JTextField textField = new JTextField();

        public MyWindow() {
            setTitle("Чат");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(300, 300, 400, 400);
            JButton jbs = new JButton("Send!");
            add(jbs);
            jbs.addActionListener(e -> sendMessage());
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
                }
            });
            jpN.add(scroll);
            jpS.add(textField);
            jpS.add(jbs);
            add(jpN);
            add("South", jpS);
            String[] data1 = {"Молли", "Баррич", "Фитц"};
            JList<String> list1 = new JList<>(data1);
            add(list1, BorderLayout.WEST);
            setVisible(true);
        }
        void sendMessage() {
            String out = textField.getText();
            textArea.append(out + "\n");
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
