package geekbrains.java2.client.model;

import geekbrains.java2.client.controller.AuthEvent;
import geekbrains.java2.client.controller.ClientController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class NetworkService {
    private final String host;
    private final int port;
    private ClientController controller;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String nickname;
    private AuthEvent successfulAuthEvent;
    private Consumer<String> messageHandler;

    public NetworkService(String host, int port, ClientController controller) {
        this.host = host;
        this.port = port;
        this.controller=controller;

    }

    public void connect() throws IOException {
        socket = new Socket(host,port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        runReadThread();
    }

    private void runReadThread() {
        new Thread(()->{
            while (true){
                try {
                    String message = in.readUTF();
                    if (message.startsWith("/authok")){
                        String [] messageParts = message.split("\\s+",2);
                        nickname = messageParts[1];
                        successfulAuthEvent.authIsSuccessful(nickname);
                    }
                    else if (messageHandler!=null) {
                        messageHandler.accept(message);
                    } else {
                        controller.showErrorMessage(message);
                    }
                } catch (IOException e) {
                    System.out.println("Поток чтения был прерван!");
                    return;
                }
            }
        }).start();
    }

    public void setSuccessfulAuthEvent(AuthEvent successfulAuthEvent) {
        this.successfulAuthEvent = successfulAuthEvent;
    }

    public void setMessageHandler(Consumer<String> messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void sendAuthMessage(String login, String pass) throws IOException {
        out.writeUTF(String.format("/auth %s %s", login,pass));
    }

    public void sendMessage (String message) throws IOException {
        out.writeUTF(message);
    }

    public void close() {
        try{
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
