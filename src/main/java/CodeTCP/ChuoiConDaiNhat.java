/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ChuoiConDaiNhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String s1 =  "B21DCCN010;IaDalYmN";
        byte[] b1 = s1.getBytes();
        os.write(b1);
        os.flush();
        
        byte[] b2 = new byte[1024];
        int read = is.read(b2, 0, b2.length);
        String s2 = new String(b2, 0, b2.length).trim();
        System.out.println(s2);
        int max = 0;
        String tmp = "";
        String res = "";
        for (char c : s2.toCharArray())
        {
            String s = String.valueOf(c);
            while (tmp.contains(s)) {
                tmp = tmp.substring(1);
            }
            tmp += c;
            if (tmp.length() > max)
            {
                max = tmp.length();
                res = tmp;
            }
        }
        String s = res + ";" + max;
        os.write(s.getBytes());
        os.flush();
        
        os.close();
        is.close();
        socket.close();
    }
}
