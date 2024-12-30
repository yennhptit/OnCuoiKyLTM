/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeUDP;

import java.io.*;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.*;

/**
 *
 * @author Admin
 */
public class KhachHang {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String qCode = "4MpxJ947";
        String studentCode = "B21DCCN008";
        
        String s1 = ";" + studentCode + ";" + qCode;
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length,inetAddress, port);
        socket.send(dp1);
        
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, port);
        socket.receive(dp2);
        
        byte[] b21 = new byte[8];
        byte[] b22 = new byte[dp2.getLength() - 8];
        System.arraycopy(b2, 0, b21, 0, 8);
        System.arraycopy(b2, 8, b22, 0, dp2.getLength() - 8);
        
        String s21 = new String(b21, 0, b21.length).trim();
        System.out.println(s21);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(b22);
        ObjectInputStream ois = new ObjectInputStream(bais);
        UDP.Customer customer = (UDP.Customer) ois.readObject();
        System.out.println(customer.toString());
                customer.chuanHoaUsername();

        customer.chuanHoaNgaySinh();
        customer.chuanHoaTen();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();
        byte[] newStudent = baos.toByteArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(b21.length + newStudent.length);
        byteBuffer.put(b21);
        byteBuffer.put(newStudent);
        byte[] b3 = byteBuffer.array();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        socket.send(dp3);
      
    }
}
