/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MaxMi {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ByteService service = (ByteService) registry.lookup("RMIByteService");
        
        String studentCode = "B21DCCN010";
        String qCode = "xO08HHJj";
        
        
        byte[] b1 = service.requestData(studentCode, qCode);
        String s = new String(b1, 0, b1.length).trim();
        System.out.println(b1);
        String[] arr = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s2 : arr)
        {
            int t = Integer.parseInt(s2.trim());
            list.add(t);
        }
        Collections.sort(list, (o1, o2) -> {
            return count(list, o1) - count(list, o2);
        });
        int as = list.get(0);
        byte[] kq = String.valueOf(as).getBytes();
        service.submitData(studentCode, qCode, kq);
    }
    public static int count(List<Integer> list, int t) {
        int cnt = 0;
        for (int t2 : list)
        {
            if (t2 == t)
            {
                cnt++;
            }
        }
        return cnt;
    }
}
