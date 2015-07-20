/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentApp;

import java.io.File;

/**
 *
 * @author QuangAnh
 */
public class Students {
   private  int id;
    private String name;
    private int number;
    private String classId;
    private File f;

    public Students() {
    }

    public Students(int id, String name, int number, String classId, File f) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.classId = classId;
        this.f = f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }
    public String[] toStringArr(){
    String[] temp={String.valueOf(id),this.name,String.valueOf(this.number),this.classId};
    return temp;
    }
}
