/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.ObjectService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class ThayDoiLuong {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService objectService = (ObjectService) registry.lookup("RMIObjectService");
        String studentCode = "B21DCCN001";
        String qCode = "bzBbdY73";
        RMI.Employee employee = (RMI.Employee) objectService.requestObject(studentCode, qCode);
        System.out.println(employee.toString());
        
        employee.changeLuong();
        
        objectService.submitObject(studentCode, qCode, employee);
    }
}
