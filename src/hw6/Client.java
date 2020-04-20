package hw6;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        new Client().start("localhost", 8189);
    }

    public void start(String host, int port) {
        Thread inputThread = null;
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Клиент запущен.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String message = reader.readLine();
            out.writeUTF(message);
            if (message.equals("/end")) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("Сервер: " + message);
                    if (message.equals("/end")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Соединение разорвано");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}