/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vidal-software
 */
public class User {
    
    private int id;
    private String userName;
    private String name;
    private String password;
    private int status;
    private String avatar;
    
    //contructors

    public User(int id, String userName, String name, String password, int status, String avatar) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
    }

    public User() {
        this.id = 0;
        this.userName = "";
        this.name = "";
        this.password = "";
        this.status = 0;
        this.avatar = "";
    }
    
    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
