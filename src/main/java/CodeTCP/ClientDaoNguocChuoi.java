/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientDaoNguocChuoi {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1289);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String s = "B21DCCN129;daonguocchuoi";
        bw.write(s);
        bw.newLine();
        bw.flush();
        
        
        String s2 = br.readLine();
        System.out.println(s2);
        
        String s3 = "";
        for (int i = s2.length() - 1; i >= 0; i--)
        {
           s3 += s2.charAt(i);
        }
        System.out.println(s3);
        bw.write(s3);
        bw.newLine();
        bw.flush();
        
        bw.close();
        br.close();
        socket.close();
        
    }
}
