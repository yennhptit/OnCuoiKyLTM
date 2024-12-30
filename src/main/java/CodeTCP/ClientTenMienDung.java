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
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClientTenMienDung {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1606);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String s = "B21DCCN129;n6Ag5dA";
        bw.write(s);
        bw.newLine();
        bw.flush();
        
        String s2 = br.readLine();
        String[] arr = s2.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String i : arr)
        {
            String curr = i.trim();
            if (curr.endsWith(".edu"))
            {
                arrayList.add(curr);
            }
                
        }
        String ans = String.join(",", arrayList);
        bw.write(ans);
        bw.newLine();
        bw.flush();
        
        bw.close();
        br.close();
        socket.close();
        
    }
}
