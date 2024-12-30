/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeUDP;

import java.net.DatagramSocket;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class MaxMin {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");
        
        int port = 2207;
        String studentCode = "B21DCCN008";
        String qCode = "Z7fdBS11";
        
        String s1 = ";" + studentCode + ";" + qCode;
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length,inetAddress, port);
        socket.send(dp1);
        
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, port);
        socket.receive(dp2);
        
        String s2 = new String(b2, 0, b2.length).trim();
        String id = s2.substring(0, 9);
        System.out.println(id);
        String cont = s2.substring(9);
        String[] arr = cont.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String t : arr)
        {
            int a = Integer.parseInt(t);
            arrayList.add(a);
        }
        int min = Collections.min(arrayList);
        int max = Collections.max(arrayList);
        id += max + "," + min;
        byte[] b3 = id.getBytes();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        socket.send(dp3);
    }
}
