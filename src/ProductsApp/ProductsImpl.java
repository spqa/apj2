/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsApp;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;

/**
 *
 * @author QuangAnh
 */
public class ProductsImpl implements ProductsInterface {

    @Override
    public JoinRowSet loadData() {
        SingleDBCOnn s = new SingleDBCOnn();
        Connection conn = s.getConnection();
        CachedRowSet rowPro;
        CachedRowSet rowManu;
        JoinRowSet rowAll = null;
        try {
            rowPro = new CachedRowSetImpl();
            rowPro.setCommand("select * from products");
            rowPro.execute(conn);
            rowManu = new CachedRowSetImpl();
            rowManu.setCommand("select * from manu");
            rowManu.execute(conn);
            rowAll = new JoinRowSetImpl();
            rowAll.addRowSet(rowPro, "manuid");
            rowAll.addRowSet(rowManu, "manuid");
            return rowAll;

        } catch (SQLException ex) {
            Logger.getLogger(ProductsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAll;
    }

    @Override
    public List<Manufacture> loadManu() {
        List<Manufacture> list = new ArrayList<>();
        SingleDBCOnn s = new SingleDBCOnn();
        CachedRowSet row;
        try {
            row = new CachedRowSetImpl();
            row.setCommand("select * from manu");
            row.execute(s.getConnection());
            while (row.next()) {
                list.add(new Manufacture(row.getInt(1), row.getString(2)));

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int AddData(int id, String name, int price, int manuID) {
       SingleDBCOnn s=new SingleDBCOnn();
        Connection connection=s.getConnection();
        try {
            PreparedStatement pre=connection.prepareStatement("insert into products values (?,?,?,?)");
            pre.setInt(1, id);
            pre.setString(2, name);
            pre.setInt(3, price);
            pre.setInt(4, manuID);
            if(pre.executeUpdate()>0){
            return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
