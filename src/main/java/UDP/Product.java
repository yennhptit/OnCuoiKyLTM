/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 20161107;
    
    public String id, code, name;
    public int quantity;

    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
    
    public void changeName()
    {
        String newName = "";
        String[] arr = name.split(" ");
        newName = arr[arr.length - 1] + " ";
        for (int i = 1; i < arr.length - 1; i++)
        {
            newName += arr[i] + " ";
        }
        newName += arr[0];
        name = newName.trim();
    }
    public void changeQua()
    {
        String qua = String.valueOf(quantity);
        String newq = "";
        for (int i = qua.length() - 1; i >= 0; i--)
        {
            newq += qua.charAt(i);
        }
        quantity = Integer.parseInt(newq.trim());
    }
}
