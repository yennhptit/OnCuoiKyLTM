/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerTongHieuTich {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1289);
        try {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String s = dis.readUTF();
            System.out.println(s);
            
            int a = 24;
            dos.writeInt(a);
            System.out.println(a);
            
            dos.flush();
            int b = 65;
            dos.writeInt(b);
            dos.flush();
            System.out.println(b);
            System.out.println(dis.readInt());
            System.out.println(dis.readInt());
            System.out.println(dis.readInt());

            
            
            
        } catch (Exception e) {
        }
    }
}
