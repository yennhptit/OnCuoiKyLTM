/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerLuythua {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1604);
        try {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] bytes = new byte[1024];
            int read = is.read(bytes);
            String s = new String(bytes, 0, bytes.length).trim();
            System.out.println(s);

            int a = (int) (Math.random() * 23) + 4;
            int b = (int) (Math.random() * 12) + 6;

            String s2 = a + "|" + b;
            byte[] bytes2 = s2.getBytes();

            os.write(bytes2);
            System.out.println(s2);
            os.flush();

            byte[] bytes3 = new byte[1024];
            int read3 = is.read(bytes3);
            String s3 = new String(bytes3, 0, bytes3.length).trim();
            System.out.println(s3);

        } 
        catch (Exception e) {
        }
    }
}
