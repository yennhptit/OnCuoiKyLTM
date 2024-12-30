/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

/**
 *
 * @author Admin
 */
public class SoLanXuatHien {
    public static void main(String[] args) throws Exception{
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        String studentCode = "B21DCCN010", qCode = "SlTGSPGM";
        List<Integer> list = port.getData(studentCode, qCode);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.sort(list);
        for (int i : list)
        {
            if (!arrayList.contains(i))
            {
                arrayList.add(i);
            }
        }
        String ans = "";
        char mo = '"';
        char dong = '"';
        List<String> data = new ArrayList<>();
        for (int i : arrayList)
        {
            ans += mo + i + ", " + cnt(list, i) + dong + ", ";
            data.add(i + ", " + cnt(list, i));
        }
        ans = ans.substring(0, ans.length() - 2);
        port.submitDataStringArray(studentCode, qCode, data);
    }
    public static int cnt(List<Integer> arrayList, int a) {
        int count = 0;
        for (Integer t : arrayList)
        {
            if (t == a)
            {
                count++;
            }
        }
        return count;
    }
    
}
