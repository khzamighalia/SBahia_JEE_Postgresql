/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String passwd;
    private String status;

    public User(int id, String name, String username, String passwd, String status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.passwd = passwd;
        this.status = status;
    }

     public User() {
    }
    public User(String name, String username, String passwd) {
        this.name = name;
        this.username = username;
        this.passwd = passwd;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
}
