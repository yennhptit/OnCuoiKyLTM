/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */

//a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân (byte[]) từ server.
//b. Chuyển đổi mảng dữ liệu nhị phân nhận được thành một chuỗi biểu diễn hex. Mỗi byte trong mảng sẽ được chuyển đổi thành hai ký tự hex tương ứng.
//Ví dụ: Nếu dữ liệu nhị phân nhận được là [72, 101, 108, 108, 111], chương trình sẽ chuyển đổi mảng này thành chuỗi hex "48656c6c6f", tương ứng với chuỗi "Hello" trong ASCII.
//c. Triệu gọi phương thức submitData để gửi chuỗi biểu diễn hex đã chuyển đổi thành mảng byte trở lại server.
//d. Kết thúc chương trình client.
public class Chuoi16 {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        String studentCode = "B21DCCN008";
        String qCode = "uHhGDBz0";
        byte[] b1 = service.requestData(studentCode, qCode);
        
        String s = new String (b1, 0, b1.length).trim();
        System.out.println(s);
        ByteBuffer buffer = ByteBuffer.allocate(s.length() * 2);
        for (char c : s.toCharArray())
        {
            int t = (int) c;
            String thex = Integer.toHexString(t);
            System.out.println(thex);
            buffer.put(thex.getBytes());
        }
        byte[] b2 = buffer.array();
        service.submitData(studentCode, qCode, b2);
    }
}
