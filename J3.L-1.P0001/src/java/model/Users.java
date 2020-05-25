/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DuongDT
 */
public class Users {
    private String userName;
    private String password;
    private String mail;
    private int role;

    public Users(String userName, String mail, int role) {
        this.userName = userName;
        this.mail = mail;
        this.role = role;
    }
    
    
    public Users(String userName, String password, String mail, int role) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public int getRole() {
        return role;
    }
    
    
}
