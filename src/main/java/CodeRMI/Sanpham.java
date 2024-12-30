/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;
import RMI.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class Sanpham {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN008";
        String qCode = "ZYG9nHVU";
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService service = (ObjectService) registry.lookup("RMIObjectService");
        
        Product product = (Product) service.requestObject(studentCode, qCode);
        product.changeCode();
        product.changePrice();
        service.submitObject(studentCode, qCode, product);
    }
    
}
