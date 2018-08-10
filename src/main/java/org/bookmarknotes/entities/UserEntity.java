package org.bookmarknotes.entities;

import javax.persistence.*;

/**
 * Created by zealot on 08.08.18.
 */
@Entity(name = "Customer")
@Table(name = "user_t")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private Long id;
    @Column
    private String login;
    @Column
    private String password;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserEntity setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
