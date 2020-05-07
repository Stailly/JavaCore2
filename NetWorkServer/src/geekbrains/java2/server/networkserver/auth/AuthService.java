package geekbrains.java2.server.networkserver.auth;

public interface AuthService {
    String getNickByLogNPass (String login, String password);

    void start();
    void stop();
}
