/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.net.Socket;
import java.nio.*;

/**
 *
 * @author Admin
 */
public class SinhVien {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String s1 = ";B21DCCN001;QABGDFxd";
        byte[] b1  = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress, port);
        socket.send(dp1);
        
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
        socket.receive(dp2);
        
        byte[] id = new byte[8];
        byte[] content = new byte[dp2.getLength() - 8];
        
        System.arraycopy(b2, 0, id, 0, 8);
        System.arraycopy(b2, 8, content, 0, dp2.getLength() - 8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        ObjectInputStream ois = new ObjectInputStream(bais);
        UDP.Student student = (UDP.Student) ois.readObject();
        System.out.println(student.name);
        student.changeEmail();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();
        
        byte[] newStudent = baos.toByteArray();
        
        ByteBuffer buffer = ByteBuffer.allocate(id.length + newStudent.length);
        buffer.put(id);
        buffer.put(newStudent);
        byte[] ans = buffer.array();
        DatagramPacket dp3 = new DatagramPacket(ans, 0, ans.length, inetAddress, port);
        socket.send(dp3);
        
        
        
        
    }
    
}
