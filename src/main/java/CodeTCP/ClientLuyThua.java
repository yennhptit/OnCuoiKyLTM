/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientLuyThua {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1604);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String s = "B21DCCN129;nxMRj8z";
        byte[] b1 = s.getBytes();
        os.write(b1);
        os.flush();
        
        byte[] b2 = new byte[1024];
        int read = is.read(b2);
        String s2 = new String(b2, 0, read).trim();
        System.out.println(s2);
        
        String[] arr = s2.split("\\|");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a);
        System.out.println(b);
        
        long ans = (long) Math.pow(a, b);
       System.out.println(ans);
       byte[] b3 = String.valueOf(ans).getBytes();
       os.write(b3);
       os.flush();
       
       os.close();
       is.close();
       socket.close();
     
    }
}
