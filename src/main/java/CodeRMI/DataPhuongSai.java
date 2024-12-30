/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.DataService;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DataPhuongSai {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        
        String s = (String) dataService.requestData("B21DCCN129", "mZGirDje");
        System.out.println(s);
        
        String[] arr = s.split(",");
        ArrayList<Float> arrayList = new ArrayList<>();
        float sum = 0F;
        for (String a : arr)
        {
            float t = Float.valueOf(a.trim());
            sum += t;
            arrayList.add(t);
            
        }
        
        float TB = sum / (float) arrayList.size();
        System.out.println(TB);
        float kq = 0F;
        
        for (float t : arrayList)
        {
            kq += (TB - t) * (TB - t);
        }
        kq /= (float) arrayList.size();

        // Tạo DecimalFormat để định dạng với 2 chữ số thập phân
        DecimalFormat df = new DecimalFormat("#.00");
        String ans = df.format(kq)+ " : " + df.format(Math.sqrt(kq));
        dataService.submitData("B21DCCN129", "mZGirDje", ans);
        
    }
}
