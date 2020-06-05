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
public class Contact {
    private String namePhotographer;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    
    public Contact() {
        
    }

    public Contact(String namePhotographer, String address, String city, String country, String phone, String email) {
        this.namePhotographer = namePhotographer;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public String getCountry() {
        return country;
    }
    
    

    public String getNamePhotographer() {
        return namePhotographer;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
