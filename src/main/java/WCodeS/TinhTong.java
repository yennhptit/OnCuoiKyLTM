/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;
import java.util.List;
import vn.medianews.*;

/**
 *
 * @author Admin
 */
public class TinhTong {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN129";
        String qCode = "nzgI67W6";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        List<Integer> datas = port.getData(studentCode, qCode);
        int sum = 0;
        for (int t : datas)
        {
            sum += t;
        }
        port.submitDataInt(studentCode, qCode, sum);
    }
}
