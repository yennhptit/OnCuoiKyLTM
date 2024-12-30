/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

/**
 *
 * @author Admin
 */
public class LonNhat {
    public static void main(String[] args) throws Exception{
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        String studentCode = "B21DCCN008";
        String qCode = "7w1nfCSP";
        
        List<Integer> list = port.getData(studentCode, qCode);
        ArrayList<String> arrayList = new ArrayList<>();
        
        String data = "";
        for (int t : list)
        {
            String s = String.valueOf(t);
            arrayList.add(s);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        for (String s : arrayList)
        {
            data += s;
        }
        System.out.println(arrayList);
        port.submitDataString(studentCode, qCode, data);
    }
}
