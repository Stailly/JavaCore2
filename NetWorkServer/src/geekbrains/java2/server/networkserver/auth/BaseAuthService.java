package geekbrains.java2.server.networkserver.auth;

import java.util.HashMap;
import java.util.Map;

public class BaseAuthService implements AuthService {

    private final Map<AuthEntry, String> NICKNAME_BY_LOGIN_AND_PASS;
    public BaseAuthService() {
        NICKNAME_BY_LOGIN_AND_PASS = new HashMap<>();
        NICKNAME_BY_LOGIN_AND_PASS.put(new AuthEntry("login1", "pass1"), "nick1");
        NICKNAME_BY_LOGIN_AND_PASS.put(new AuthEntry("login2", "pass2"), "nick2");
        NICKNAME_BY_LOGIN_AND_PASS.put(new AuthEntry("login3", "pass3"), "nick3");
    }

    @Override
    public String getNickByLogNPass(String login, String password) {
        return NICKNAME_BY_LOGIN_AND_PASS.get(new AuthEntry(login, password));
    }

    @Override
    public void start() {
        System.out.println("Auth service has been started");
    }

    @Override
    public void stop() {
        System.out.println("Auth service has been stopped");
    }
}
