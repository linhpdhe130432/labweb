/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author Minh
 */
public class ContactDao {
    
    // get All detail of Contact
     public List<Contact> getAll() {
        String query = "SELECT * FROM Contact";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) // Chuẩn bị câu query
        {
            ResultSet rs = ps.executeQuery();
            List<Contact> list = new ArrayList<>();
                while (rs.next()) {
                    Contact contact = new Contact(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBoolean(7));
                    list.add(contact);
                }
                return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
