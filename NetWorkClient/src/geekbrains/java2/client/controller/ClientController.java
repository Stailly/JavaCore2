package geekbrains.java2.client.controller;

import geekbrains.java2.client.view.AuthDialog;
import geekbrains.java2.client.view.ClientChat;
import geekbrains.java2.client.model.NetworkService;

import javax.swing.*;
import java.io.IOException;


public class ClientController {
    private final NetworkService networkService;
    private final AuthDialog authDialog;
    private final ClientChat clientChat;


    public ClientController(String serverHost, int serverPort) {
        this.networkService=new NetworkService(serverHost, serverPort, this);
        this.authDialog = new AuthDialog(this);
        this.clientChat = new ClientChat(this);
    }

    public void runApplication() throws IOException {
        connectToServer();
        runAuthProcess();
    }

    private void runAuthProcess() {
        networkService.setSuccessfulAuthEvent(nickname -> {
            ClientController.this.setUserName(nickname);
            ClientController.this.openChat();
        });
        authDialog.setVisible(true);
    }

    private void openChat() {
        authDialog.dispose();
        networkService.setMessageHandler(clientChat::appendMessage);
        clientChat.setVisible(true);
    }

    private void setUserName(String nickname) {
        SwingUtilities.invokeLater(()-> clientChat.setTitle(nickname));
    }

    private void connectToServer() throws IOException {
        try {
            networkService.connect();
        } catch (IOException e) {
            System.err.println("Failed to establish server connection");
            throw e;
        }
    }

    public void sendAuthMessage(String login, String pass) throws IOException {
        networkService.sendAuthMessage(login, pass);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(authDialog,message);
    }

    public void sendMessage (String message) {
        try {
            networkService.sendMessage(message);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения!");
        }
    }

    public void shutdown () {
        networkService.close();
    }

    public void sendPrivateMessage (String username, String message) {
        sendMessage(String.format("/w %s %s", username, message));
    }
}
