/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientLoaiBoNgyuenAm {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1606);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String s = "B21DCCN129;x8c45mq";
        bw.write(s);
        bw.newLine();
        bw.flush();
        
        String s2 = br.readLine().trim();
        String ans = "";
        for (char c : s2.toCharArray())
        {
            if (c != 'a' && c != 'e' && c != 'u' && c != 'i' && c != 'o')
            {
                ans += c;
            }
        }
        bw.write(ans);
        bw.newLine();
        bw.flush();
        
        bw.close();
        br.close();
        socket.close();
    }
}
