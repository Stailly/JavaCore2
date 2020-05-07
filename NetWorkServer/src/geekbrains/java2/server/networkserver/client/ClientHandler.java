package geekbrains.java2.server.networkserver.client;

import geekbrains.java2.server.networkserver.MyServer;
import geekbrains.java2.server.networkserver.auth.AuthService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket clientSocket;
    private final MyServer myServer;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private AuthService authService;
    private String nickname;

    public ClientHandler(Socket clientSocket, MyServer myServer) {
        this.clientSocket=clientSocket;
        this.myServer=myServer;
        this.authService=myServer.getAuthService();
    }
    public void handle() throws IOException {
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(()->{
            try {
                authentication();
                readMessages();
            } catch (IOException e) {
                System.out.println("Connection has been failed...");
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void closeConnection() {
        myServer.unsubscribe(this);
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String message = inputStream.readUTF();
            if (message.startsWith("/end")){
                return;
            }
            else if (message.startsWith("/w")) {
                String[] parts = message.split("\\s+", 3);
                String username = parts[1];
                String privateMessage = parts[2];
                myServer.sendPrivateMessage(username, buildMessage(privateMessage));
            }
            else {
                myServer.broadcastMessage(nickname + ": " + message);
            }
        }
    }
    private String buildMessage(String message){
        return String.format("%s: %s", nickname,message);
    }

    private void authentication() throws IOException {
        while (true) {
            String message = inputStream.readUTF();
            if (message.startsWith("/auth")) {
                String [] parts = message.split("\\s+");
                String login = parts[1];
                String password = parts[2];
                String nickname = authService.getNickByLogNPass(login,password);
                if (nickname==null) {
                    sendMessage("Неверно введён логин/пароль");
                }
                else if (myServer.IsNickBusy(nickname)){
                    sendMessage("Учётная запись уже используется");
                }
                else {
                    sendMessage("/authok " + nickname);
                    setNickname(nickname);

                    myServer.broadcastMessage(nickname + " зашёл в чат!");
                    myServer.subscribe(this);
                    break;
                }
            }
        }
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname(){
        return nickname;
    }

    public void sendMessage(String message) throws IOException {
        outputStream.writeUTF(message);
    }
}
