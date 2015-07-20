/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class StudentsImpl implements StudentInterface{

    @Override
    public int addData(int id, String name, int number, String classId, File f) {
       SingleDBConn s=new SingleDBConn();
        Connection conn=s.getConnection();
        try {
            PreparedStatement pre=conn.prepareStatement("insert into tblImg values(?,?,?,?,?)");
            pre.setInt(1, id);
            pre.setString(2, name);
            pre.setInt(3, number);
            pre.setString(4, classId);
            FileInputStream fis=new FileInputStream(f);
            pre.setBlob(5, fis);
            if(pre.executeUpdate()>0){
            return 1;
            }
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(StudentsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<Students> loadData() {
        List<Students> list=new ArrayList<>();
        SingleDBConn s=new SingleDBConn();
        Connection conn=s.getConnection();
        try {
            PreparedStatement pre=conn.prepareStatement("select * from tblimg");
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int i=0;
                FileOutputStream f=new FileOutputStream("src/studentApp/img/"+i+".jpg");
                Blob img=rs.getBlob(5);
                InputStream is=img.getBinaryStream();
                int read;
                while((read=is.read())!=-1){
                    f.write(read);
                }
                list.add(new Students(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), new File("src/studentApp/img/"+i+".jpg")));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
