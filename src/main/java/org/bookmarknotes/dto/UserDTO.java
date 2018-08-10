package org.bookmarknotes.dto;

/**
 * Created by zealot on 09.08.18.
 */
public class UserDTO {
    private String login;
    private String password;

    public UserDTO() {
    }

    public String getLogin() {
        return login;
    }

    public UserDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
