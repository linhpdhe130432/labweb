/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Minh
 */
public class Contact {
    private int id;
    private String name,address,tel,email,openingHours;
    private boolean isOnHomePage;

    public Contact() {
    }

    public Contact(int id, String name, String address, String tel, String email, String openingHours, boolean isOnHomePage) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
        this.isOnHomePage = isOnHomePage;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isIsOnHomePage() {
        return isOnHomePage;
    }

    public void setIsOnHomePage(boolean isOnHomePage) {
        this.isOnHomePage = isOnHomePage;
    }
    
    
}
