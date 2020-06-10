/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Introduction;
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
public class IntroductionDao {

    // get All detail of introduction
    public List<Introduction> getAll() {
        String query = "SELECT * FROM Introduction";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = con.prepareStatement(query)) // Chuẩn bị câu query
        {
            ResultSet rs = ps.executeQuery();
            List<Introduction> list = new ArrayList<>();
                while (rs.next()) {
                    Introduction intro = new Introduction(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                    list.add(intro);
                }
                return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
