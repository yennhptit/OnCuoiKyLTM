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
public class LoaiBoChuoi {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String s1 = "B21DCCN001;UqmVjVRF";
        bw.write(s1);
        bw.newLine();
        bw.flush();
        
        String s2 = br.readLine();
        String s3 = br.readLine();
        System.out.println(s2);
        System.out.println(s3);
        
        String kq = "";
        for(char c : s2.toCharArray())
        {
            String kt = String.valueOf(c);
            if (!s3.contains(kt))
            {
                kq += c;
            }
        }
        System.out.println(kq);
        
        bw.write(kq);
        bw.newLine();
        bw.flush();
        
        bw.close();
        br.close();
        socket.close();
    }
}
