/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contact;

/**
 *
 * @author DuongDT
 */
public class ContactDAO {
    
    // get data of contact
    public Contact getContact() throws Exception {
        
        Contact result = new Contact();
        String sql = "  select top 1 * from Contact";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext context = new DBContext();
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getNString("Name");
                String address = rs.getNString("Address");
                String city = rs.getNString("City");
                String country = rs.getNString("Country");
                String phone = rs.getString("Telephone");
                String email = rs.getString("email");
                result = new Contact(name, address, city, country, phone, email);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //close connect
            new DBContext().closeConnection(rs, ps, conn);
        }

        return result;
    }
}
