/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsApp;

/**
 *
 * @author QuangAnh
 */
public class Products {
    private String id;
    private String name;
    private String price;
    private int ManuID;

    public Products() {
    }

    public Products(String id, String name, String price, int ManuID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ManuID = ManuID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getManuID() {
        return ManuID;
    }

    public void setManuID(int ManuID) {
        this.ManuID = ManuID;
    }
    
    
}
