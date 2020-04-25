package geekbrains.java2.server.networkserver.auth;

import java.util.Objects;

public class AuthEntry {
    private String login;
    private String password;

    public AuthEntry(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthEntry authEntry = (AuthEntry) o;
        return Objects.equals(login, authEntry.login) &&
                Objects.equals(password, authEntry.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}

