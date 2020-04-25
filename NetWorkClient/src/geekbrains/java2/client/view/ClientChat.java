package geekbrains.java2.client.view;

import geekbrains.java2.client.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ClientChat extends JFrame {
    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea);
    JTextField textField = new JTextField();
    String[] data1 = {"nick1", "nick2", "nick3"};
    JList<String> usersList = new JList<>(data1);
    JButton sendButton = new JButton("Send!");
    private  ClientController controller;


    public ClientChat(ClientController controller) {
        this.controller=controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        add(sendButton);
        jpN.add(scroll);
        jpS.add(textField);
        jpS.add(sendButton);
        add(jpN);
        add("South", jpS);
        add(usersList, BorderLayout.WEST);
        addListeners();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
            }
        });
    }

    private void addListeners() {
        sendButton.addActionListener(e -> ClientChat.this.sendMessage());
        textField.addActionListener(e -> sendMessage());
    }

    void sendMessage() {
        String message = textField.getText().trim();
        if (message.isEmpty()) {
            return;
        }
        if (usersList.getSelectedIndex() < 1){
            controller.sendMessage(message);
        } else {
            String username = usersList.getSelectedValue();
            controller.sendPrivateMessage(username,message);
        }
        textField.setText(null);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(message);
            textArea.append(System.lineSeparator());
        });
    }

}

