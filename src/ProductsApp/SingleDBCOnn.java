/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class SingleDBCOnn {
    public Connection getConnection(){
        Connection conn=null;
        try {
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(SingleDBCOnn.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  conn;
    }
    public void closeConn(Connection con){
    if(con!=null){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SingleDBCOnn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
}
