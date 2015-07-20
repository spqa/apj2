/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentApp;

import java.io.File;
import java.util.List;

/**
 *
 * @author QuangAnh
 */
public interface StudentInterface {
    public int addData(int id,String name,int number ,String classId,File f);
    public List<Students> loadData();
}
