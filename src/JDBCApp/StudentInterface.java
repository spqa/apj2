/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCApp;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 *
 * @author QuangAnh
 */
public interface StudentInterface {
    public java.util.List<Students> loadData();
    public int AddData(int id,String name,String address,int age) throws MySQLIntegrityConstraintViolationException;
    public int UpdateData(int id,String name,String address,int age);
    public int DeleteData(int id);
}
