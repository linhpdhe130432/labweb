/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.News;

/**
 *
 * @author DuongDT
 */
public class NewsDAO {
    
    // get id, short des and title of newest for 5 last news 
    public List<News> getTop5Newest() throws Exception {
        List<News> result = new ArrayList<>();
        String sql = "select top 5 * from New\n" +
        "order by createdAt desc";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            DBContext context = DBContext.getContext();
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getNString("title");
                String shortDes = rs.getNString("shortDes");
                result.add(new News(id, title, shortDes));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }
        return result;
    }
    
    // get the last newest
    public News getNewest() throws Exception {
        News result = null;
        String sql = "select top 1 * from New\n" +
        "order by createdAt desc";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            DBContext context = DBContext.getContext();
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getNString("title");
                String shortDes = rs.getNString("shortDes");
                String author = rs.getNString("author");
                String content = rs.getNString("content");
                String image = rs.getString("imageDes");
                // In column createAt, get Date for date and get Time to get Hours and Minutes
                Date dateCreate = rs.getDate("createdAt");
                Date timeCreate = rs.getTime("createdAt");
                
                // Format for date and time
                DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
                DateFormat timeFormat = new SimpleDateFormat("hh:mmaa");
                String time = timeFormat.format(timeCreate).toLowerCase();
                if (time.startsWith("0")) {
                    time = time.substring(1);
                }
                // Add string to have MMM dd yyyy hh:mm aa date format
                String date = dateFormat.format(dateCreate)+" - "+time;               
                result = new News(id, title, shortDes, content, author, context.getImageURL()+image, date);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }
        return result;
    }
    
    // Get new by id 
     public News getNewById(int id) throws Exception {
        News result = null;
        String sql = "select top 1 * from New\n" +
        "where id = ?";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            DBContext context = DBContext.getContext();
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getNString("title");
                String shortDes = rs.getNString("shortDes");
                String author = rs.getNString("author");
                String content = rs.getNString("content");
                String image = rs.getString("imageDes");
                
                // In column createAt, get Date for date and get Time to get Hours and Minutes
                Date dateCreate = rs.getDate("createdAt");
                Date timeCreate = rs.getTime("createdAt");
                
                // Format for date and time
                DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
                DateFormat timeFormat = new SimpleDateFormat("hh:mmaa");
                String time = timeFormat.format(timeCreate).toLowerCase();
                if (time.startsWith("0")) {
                    time = time.substring(1);
                }
                // Add string to have MMM dd yyyy hh:mm aa date format
                String date = dateFormat.format(dateCreate)+" - "+time;
                result = new News(id, title, shortDes, content, author, context.getImageURL()+image, date);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }
        return result;
    }
     
    // Function to search news by title. 
    public List<News> searchByKeyword(String keyword, int pageNumber, int pageSize) throws Exception {
        List<News> result = new ArrayList<>();
        String sql = "SELECT * FROM ( \n" +
        "  SELECT *\n" +
        "  , ROW_NUMBER() OVER(ORDER by id) as row \n" +
        "  FROM New n\n" +
        "  where title like ?\n" +
        " ) g WHERE g.row >= ? and g.row <= ? ";
        
        // SQL Query for pagging: Skip the first (page number - 1)x page size + 1 row
        // and the next page number x page size
        // This query use to get data with limit row.
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            DBContext context = DBContext.getContext();
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setNString(1, "%"+keyword+"%");
            ps.setInt(2, (pageNumber-1)*pageSize +1);
            ps.setInt(3, pageSize*pageNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getNString("title");
                String shortDes = rs.getNString("shortDes");
                String image = rs.getString("imageDes");
                result.add(new News(id, title, shortDes,context.getImageURL()+image));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }
        
        return result;
    } 
    
    // Function to get total news in search with keyword
    public int getTotalSearch(String keyword) throws Exception {
        int result = 0;
        String sql = "select  COUNT(*)  from New\n" +
        "where title like ?";
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            DBContext context = DBContext.getContext();
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setNString(1, "%"+keyword+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                // The result only have 1 column
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }
        return result;
    }
}
