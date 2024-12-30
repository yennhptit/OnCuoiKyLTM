/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class SinhVien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2209); 
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        
        String s1 = "B21DCCN001;U36kXJVG";
        os.writeObject(s1);
        os.flush();
        
        TCP.Student student = (TCP.Student) is.readObject();
        System.out.println(student.toString());
        student.change();
        
        os.writeObject(student);
        os.flush();
        
        os.close();
        is.close();
        socket.close();
    }
}
