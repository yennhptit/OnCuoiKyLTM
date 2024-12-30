package CodeTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class UocBoi {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "RPgwbdHJ";
        int port = 2207;
        String host = "203.162.10.109";

        Socket socket = new Socket(host, port);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String s1 = studentCode + ";" + qCode;
        dos.writeUTF(s1);
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();

        int ucln = ucln(a, b);
        int bcnn = a * b / ucln;
        //ước chung lớn nhất, bội chung nhỏ nhất, tổng, tích

        dos.writeInt(ucln);
        dos.flush();
        dos.writeInt(bcnn);
        dos.flush();
        dos.writeInt(a + b);
        dos.flush();
        dos.writeInt(a * b);
        dos.flush();

        dos.close();
        dis.close();
        socket.close();
    }
    public static int ucln (int a, int b)
    {
        if ( a % b == 0)
            return b;
        return ucln(b, a % b);
    }

}
