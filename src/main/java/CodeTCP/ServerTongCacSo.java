/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServerTongCacSo {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1289);
        try {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            
            byte[] b1 = new byte[1024];
            int read = is.read(b1);
            String s = new String(b1, 0, b1.length).trim();
            System.out.println(s);
            
            int n = 10;
            ArrayList<Integer> arrayList = new ArrayList<>();
            String ans = "";
            for (int i = 0; i < 10; i++)
            {
                int temp = (int) (Math.random() * 100) + 76;
                ans += String.valueOf(temp) + "|";
            }
            System.out.println(ans);
            ans = ans.substring(0, ans.length() - 1);
            System.out.println(ans);
            os.write(ans.getBytes());
            os.flush();
            
            byte[] b3 = new byte[1024];
            int r3 = is.read(b3);
            String s3 = new String(b3, 0, b3.length).trim();
            System.out.println(s3);
            
        } catch (Exception e) {
        }
    }
}
