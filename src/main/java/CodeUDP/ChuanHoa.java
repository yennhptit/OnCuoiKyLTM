/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeUDP;

import java.net.DatagramSocket;
import java.net.*;

/**
 *
 * @author Admin
 */
public class ChuanHoa {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String s1 = ";B21DCCN001;NRVwBVvx";
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress, port);
        datagramSocket.send(dp1);
        
        
       byte[] b2 = new byte[1024];
       DatagramPacket dp2 = new DatagramPacket(b2, b2.length, inetAddress, port);
       datagramSocket.receive(dp2);
       String s2 = new String(b2,0, b2.length).trim();
        System.out.println(s2);
        
        String id = s2.substring(0, 9);
        String cont = s2.substring(9);
        
        String[] arr = cont.split("\\s+");
        for (String s : arr)
        {
            s = s.toUpperCase();
            s = s.charAt(0) + s.substring(1).toLowerCase();
            System.out.println(s);
            id += s + " ";
        }
        id = id.trim();
        System.out.println(id);
        byte[] b3 = id.getBytes();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        datagramSocket.send(dp3);
      
    }
}
