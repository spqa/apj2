/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class SingleDBconn {
    Connection conn=null;
    public Connection getConnection(){
    
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdata", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(SingleDBconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    return conn;
    }
    public void closeConnection(Connection conn){
    if(conn!=null){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SingleDBconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
