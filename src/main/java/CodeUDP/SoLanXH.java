package CodeUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class SoLanXH {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "OfhVqq9h";
        int port = 2208;
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String s1 = ";" + studentCode + ";" + qCode;
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress, port);
        socket.send(dp1);

        //requestId;data requestId;5a2z3b2c1d aaazbbbccdaaz
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, port);
        socket.receive(dp2);

        String s2 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        String[] arr = s2.split(";");
        String id = arr[0] + ";";
        String data = arr[1];
        String ans = "";
        for (char c : data.toCharArray())
        {
            String s = c + "";
            if(!ans.contains(s))
            {
                ans += count(data, c) + s;
            }
        }
        String s3 = id + ans;
        byte[] b3 = s3.getBytes();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        socket.send(dp3);
    }
    public static int count(String s, char check)
    {
        int cnt = 0;
        for (char c : s.toCharArray())
        {
            if(c == check)
            {
                cnt++;
            }
        }
        return cnt;
    }
}
