/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsApp;

import java.util.List;
import javax.sql.rowset.JoinRowSet;

/**
 *
 * @author QuangAnh
 */
public interface ProductsInterface {
    public JoinRowSet loadData();
    public List<Manufacture> loadManu();
    public int AddData(int id,String name,int price,int manuID);
}
