/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.BufferedReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerLoaiBoNgyenAm {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1606);
        try {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while (true) {                
                String s = br.readLine();
                System.out.println(s);
                
                String s2 = "Hello Java Programming!";
                bw.write(s2);
                bw.newLine();
                bw.flush();
                
                String s3 = br.readLine();
                System.out.println(s3);
                
            }
            
                    
            
            
        } catch (Exception e) {
        }
    }
}
