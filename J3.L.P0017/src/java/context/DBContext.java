/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author DuongDT
 */
public class DBContext {
    
    private InitialContext initCxt;
    private Context envirCxt;
    private String serverName;
    private String port;
    private String username;
    private String password;
    private String dbName;
    private String imgFolder;

    public DBContext() throws Exception {
        initCxt = new InitialContext();
        envirCxt = (Context) initCxt.lookup("java:/comp/env");
        // get value of parameter in context file 
        
        serverName = (String) envirCxt.lookup("severName");
        port = (String) envirCxt.lookup("port");
        username = (String) envirCxt.lookup("username");
        password = (String) envirCxt.lookup("password");
        dbName = (String) envirCxt.lookup("dbName");
        imgFolder = (String) envirCxt.lookup("imgFolder");
    }
    
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + port + ";databaseName=" + dbName, username, password);
    }
    // Return String is location of images directory 
    public String getImageURL() throws Exception {
        return imgFolder;
    }
    // Close connection
    public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException { 
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
