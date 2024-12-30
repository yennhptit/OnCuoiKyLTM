/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientUCLNBCNN {
    public static int getucln(int a, int b)
    {
        if (a % b == 0)
            return b;
        return getucln(b, a%b);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1605);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        String studentCode = "B21DCCN129";
        String qCode = "i9VhkNb";
        
        String s1 = studentCode + ";" + qCode;
        dos.writeUTF(s1);
        dos.flush();
        
        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println(a);
        System.out.println(b);
        int ucln = getucln(a, b);
        int bcnn = a * b / ucln;
        dos.writeInt(ucln);
        dos.flush();
        dos.writeInt(bcnn);
        dos.flush();
        
        dos.close();
        dis.close();
        socket.close();
        
    }
}
