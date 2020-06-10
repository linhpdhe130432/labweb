/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cake;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author Minh
 */
public class CakeDao {
    
    // get top 3 product on DB
    public List<Cake> getTop4Cake() {
        String query = "SELECT TOP 4 * FROM Cake\n"
                + "ORDER BY createdDate ASC";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) // Chuẩn bị câu query
        {
            ResultSet rs = ps.executeQuery();
            List<Cake> list = new ArrayList<>();
            while (rs.next()) {
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7));
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    // get all product on DB
    public List<Cake> getAll() {
        String query = "SELECT * FROM Cake";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) // Chuẩn bị câu query
        {
            ResultSet rs = ps.executeQuery();
            List<Cake> list = new ArrayList<>();
            while (rs.next()) {
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7));
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
 
    // get product by id which is returned when users click on 1 product
    public Cake getCakeByID(int id) {
        Cake cake = null;
        String query = "SELECT * FROM Cake\n"
                + "where id = ?";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) // Chuẩn bị câu query
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7)); 
            }
            return cake;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
     // get list of cake on each page 
    public List<Cake> getCakePaging(int pageindex, int pagesize) {
        List<Cake> list = new ArrayList<>();
        String query = "SELECT * FROM\n"
                + "	(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM Cake) tblCake\n"
                + "WHERE row_num >= (? - 1)*? + 1 AND row_num <= ? * ?";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, pageindex);
            ps.setInt(3, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(4, pagesize);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7));
                list.add(cake);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    // this func returns the number of product on DB
    public int count() {
        String sql = "SELECT COUNT(*) as rownum FROM Cake";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("rownum");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return -1;
    }
}
