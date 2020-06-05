/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Information;

/**
 *
 * @author DuongDT
 */
public class InformationDAO {

    public Information getHomeInfo() throws Exception {

        Information result = new Information();
        String sql = "  select top 1 * from Information";
        // start connect
        Connection conn = null;
        ResultSet rs = null;
        try {
            DBContext context = new DBContext();
            conn = new context.DBContext().getConnection();
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String about = rs.getNString("About");
                String sortDes = rs.getNString("ShortAbout");
                String imageUrl = rs.getString("ImageAboutUrl");
                result = new Information(about, sortDes, context.getImageURL() + imageUrl);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //close connection
            rs.close();
            conn.close();
        }
        return result;
    }
}
