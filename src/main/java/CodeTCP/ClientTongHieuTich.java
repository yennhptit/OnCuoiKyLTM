/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientTongHieuTich {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1289);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        String s = "B21DCCN129;tonghieutich";
        dos.writeUTF(s);
        dos.flush();
        
        int a = dis.readInt();
        System.out.println(a);
        int b = dis.readInt();
        System.out.println(a);
        System.out.println(b);
        dos.writeInt((int)(a+b));
        dos.flush();
        dos.writeInt((int) (a-b));
        dos.flush();
        dos.writeInt((int)(a*b));
        dos.flush();
    }
}
