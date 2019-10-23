package com.entity;

import java.io.Serializable;

public class UserBean implements Serializable{

    private String user;
    private String pwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserBean(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public UserBean() {

    }

    public String toString() {
        return "UserBean{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
