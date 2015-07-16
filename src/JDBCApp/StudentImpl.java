/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCApp;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class StudentImpl implements StudentInterface{

    @Override
    public List<Students> loadData() {
        List<Students> list=new ArrayList<>();
        SingleDBconn s=new SingleDBconn();
        Connection conn=null;
        try {
            
            conn=s.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from tblstu");
            while(rs.next()){
                list.add(new Students(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        s.closeConnection(conn);
        }
        return list;
    }

    @Override
    public int AddData(int id,String name,String address,int age) throws MySQLIntegrityConstraintViolationException{
        SingleDBconn s=new SingleDBconn();
        Connection conn=s.getConnection();
        int result;
        try {
            PreparedStatement pre=conn.prepareStatement("insert into tblstu value(?,?,?,?)");
            pre.setInt(1, id);
            pre.setString(2, name);
            pre.setString(3, address);
            pre.setInt(4, age);
            result=pre.executeUpdate();
            if(result>0){
            return 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        s.closeConnection(conn);
        }
        return 0;
    }

    @Override
    public int UpdateData(int id, String name, String address, int age) {
        SingleDBconn s=new SingleDBconn();
        Connection conn=s.getConnection();
        int result;
        try {
            PreparedStatement pre=conn.prepareStatement("update `tblstu` set `name`=?, `address`=? ,`age` =? where `id`=?");
            pre.setString(1, name);
            pre.setString(2 , address);
            pre.setInt(3, age);
            pre.setInt(4, id);
            result=pre.executeUpdate();
            if(result>0){
            return 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        s.closeConnection(conn);
        }
        return 0;
    }

    @Override
    public int DeleteData(int id) {
        SingleDBconn s=new SingleDBconn();
        Connection connection=s.getConnection();
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement("delete from tblstu where id=?");
            pre.setInt(1, id);
            return pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        s.closeConnection(connection);
        }
        return 0;
    }
    
}
