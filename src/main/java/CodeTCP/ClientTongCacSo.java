/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientTongCacSo {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1289);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String s = "B21DCCN129;tongcacso";
        byte[] b1 = s.getBytes();
        os.write(b1);
        os.flush();
        
        byte[] b2 = new byte[1024];
        int read = is.read(b2);
        String s2 = new String(b2, 0, b2.length).trim();
        System.out.println(s2);
        
        String[] arr = s2.split("\\|");
        int sum = 0;
        for (String i : arr)
        {
            System.out.println(i);
            int t = Integer.valueOf(i.trim());
            sum += t;
        }
        System.out.println(sum);
        byte[] b3 = String.valueOf(sum).getBytes();
        os.write(b3);
        os.flush();
        
        os.close();
        is.close();
        socket.close();
        
    }
}
