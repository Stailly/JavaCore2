package geekbrains.java2.client.view;

import geekbrains.java2.client.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class AuthDialog extends JFrame {
    private ClientController controller;
    JTextField login = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel enterLogin = new JLabel("Введите логин:");
    JLabel enterPass = new JLabel("Введите пароль:");
    JButton authButton = new JButton("Authorize");
    JButton exitButton = new JButton("Exit");

    public AuthDialog(ClientController controller) {
        this.controller=controller;
        setTitle("Авторизация");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 120);
        setLayout(new GridLayout(3, 2));
        add(enterLogin);
        add(login);
        add(enterPass);
        add(password);
        add(authButton);
        add(exitButton);
        authButton.addActionListener(e -> {
            try {
                onOK();
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при попытке аутентификации");
        }
        });
        exitButton.addActionListener(e -> onCancel());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void onCancel() {
        System.exit(0);
    }

    private void onOK() throws IOException {
        String loginString = login.getText().trim();
        String pass = new String(password.getPassword()).trim();
        controller.sendAuthMessage(loginString, pass);
    }


}
