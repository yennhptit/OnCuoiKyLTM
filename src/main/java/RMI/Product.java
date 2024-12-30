/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 20151107L;
    public String id, code;
    public double importPrice, exportPrice;

    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", importPrice=" + importPrice + ", exportPrice=" + exportPrice + '}';
    }
    
    public void changeCode()
    {
        code = code.toUpperCase();
    }
    public void changePrice()
    {
        exportPrice = importPrice * 1.2;
    }
}
