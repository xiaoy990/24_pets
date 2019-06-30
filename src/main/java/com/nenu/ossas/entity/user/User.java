package com.nenu.ossas.entity.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = -2875497843802360359L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(length = 50)
    private String userName;

    @Column(length = 50)
    private String passWord;

    @Column(length = 50)
    private String perms;

    @Column(length = 50)
    private String role;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perm) {
        this.perms = perm;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", perms='" + perms + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
