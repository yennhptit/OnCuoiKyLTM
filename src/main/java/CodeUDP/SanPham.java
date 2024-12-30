/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 *
 * @author Admin
 */
public class SanPham {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");
        
        byte[] b1 = ";B21DCCN010;Yo9CTcub".getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress,2209);
        socket.send(dp1);
        
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, 2209);
        socket.receive(dp2);
        String s2 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        
        byte[] b21 = new byte[8];
        byte[] b22 = new byte[dp2.getLength() - 8];
        
        System.arraycopy(b2, 0, b21, 0,8);
        System.arraycopy(b2, 8, b22, 0, dp2.getLength() - 8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(b22);
        ObjectInputStream ois = new ObjectInputStream(bais);
        UDP.Product product = (UDP.Product) ois.readObject();
        
        product.changeName();
        product.changeQua();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();
        
        byte[] b23 = baos.toByteArray();
        
        ByteBuffer buffer = ByteBuffer.allocate(b23.length + b21.length);
        buffer.put(b21);
        buffer.put(b23);
        byte[] ans = buffer.array();
        DatagramPacket dp3 = new DatagramPacket(ans, 0, ans.length, inetAddress, 2209);
        socket.send(dp3);
    }
}
