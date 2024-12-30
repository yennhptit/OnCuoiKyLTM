/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.Book;
import RMI.ObjectService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class ObjectBook {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService objectService = (ObjectService) registry.lookup("RMIObjectService");
        
        Book book = (Book) objectService.requestObject("B21DCCN129", "Zh16PQ3V");
        System.out.println(book.toString());
        
        
        book.setCodeForBook();
        System.out.println(book.getCode());
        System.out.println(book.getTitle());
       
       objectService.submitObject("B21DCCN129", "Zh16PQ3V", book);
        
    }
}
