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
import java.util.ArrayList;
import java.util.List;
import model.Gallery;

/**
 *
 * @author DuongDT
 */
public class GalleryDAO {

    // Get all gallery to get all info of gallery except list images in home screen with pageNumber
    public List<Gallery> getInfoGallery(int pageNumber, int pageSize) throws Exception {
        List<Gallery> listResult = new ArrayList<>();

        String sql = "SELECT * FROM ( \n" +
        "  SELECT g.Code,g.DescriptionImageUrl,g.DescriptionText,g.GalleryName\n" +
    "  , ROW_NUMBER() OVER(ORDER by Code) as row \n" +
    "  FROM Gallery g\n" +
    " ) g WHERE g.row >= ? and g.row <= ? ";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        // SQL Query for pagging: Skip the first (page number - 1)x page size + 1 row
        // and the next page number x page size
        // This query use to get data with limit row.
        try {
            DBContext context = new DBContext();
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, (pageNumber-1)*pageSize +1);
            ps.setInt(2, pageSize*pageNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                int galleryCode = rs.getInt("Code");
                String galleryName = rs.getNString("GalleryName");
                String galleryDes = rs.getNString("DescriptionText");
                String galleryDesImage = rs.getString("DescriptionImageUrl");
                listResult.add(new Gallery(galleryCode, galleryName, galleryDes, context.getImageURL() + galleryDesImage));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //close connect
            new DBContext().closeConnection(rs, ps, conn);
        }

        return listResult;
    }
    
    // Get the number of total gallery having in DB
    public int getTotalGallery() throws Exception {
        int result = 0;
        String sql = "select  COUNT(Code)  from Gallery";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            // result in SQL will return 1 column 
            rs = ps.executeQuery();
            while (rs.next()) {
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

    // Get info of all gallery with code and name to use in header
    public List<Gallery> getInfoAllGalleryForHeader() throws Exception {
        List<Gallery> listResult = new ArrayList<>();

        String sql = "select top 3 * from Gallery";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int galleryCode = rs.getInt("Code");
                String galleryName = rs.getNString("GalleryName");
                listResult.add(new Gallery(galleryCode, galleryName));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            new DBContext().closeConnection(rs, ps, conn);
        }

        return listResult;
    }

    
    // Get all images of a gallery by galleryCode
    public List<String> getImageUrlByIdGallery(int id, int pageNumber, int pageSize) throws Exception {
        // get Data with pagging 
        List<String> listImg = new ArrayList<>();
        String sql = " SELECT * FROM ( \n" +
        "  SELECT g.ImageUrl,g.ImageCode\n" +
        "  , ROW_NUMBER() OVER(ORDER by ImageCode) as row \n" +
        "  FROM ImageInGallery g\n" +
        "  where g.GalleryCode = ?\n" +
        " ) g WHERE g.row >= ? and g.row <= ? ";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        // Input the id of Gallery to get list all images in this gallery
        
        // SQL Query for pagging: Skip the first (page number - 1)x page size + 1 row
        // and the next page number x page size
        // This query use to get data with limit row.
        
        
        try {
            DBContext context = new DBContext();
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, (pageNumber-1)*pageSize + 1);
            ps.setInt(3, pageNumber*pageSize );
            rs = ps.executeQuery();

            while (rs.next()) {
                String url = rs.getString("ImageUrl");
                listImg.add(context.getImageURL() + url);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            new DBContext().closeConnection(rs, ps, conn);
        }

        return listImg;
    }

    // Get all info and list image in gallery with galleryCode
    public Gallery getGalleryById(int id, int pageNumber, int pageSize) throws Exception {

        Gallery result = new Gallery();
        String sql = "select top 1 * from Gallery where Code = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            DBContext context = new DBContext();
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String galleryName = rs.getNString("GalleryName");
                String galleryDes = rs.getNString("DescriptionText");
                String galleryDesImage = rs.getString("DescriptionImageUrl");
                List<String> listImage = getImageUrlByIdGallery(id, pageNumber, pageSize);
                result = new Gallery(id, galleryName, galleryDes, context.getImageURL() + galleryDesImage, listImage);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // close connection
            new DBContext().closeConnection(rs, ps, conn);
        }

        return result;
    }

    // compute the total image in one gallery by id. Using for display pagging
    public int getTotalImage(int id) throws Exception {
        int result = 0;
        String sql = "select COUNT(*) from ImageInGallery\n"
                + "where GalleryCode = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // result in SQL will return 1 column 
            rs = ps.executeQuery();
            while (rs.next()) {
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
