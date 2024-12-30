package CodeUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChuoiSoThieu {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "oRS4IpZF";
        int port = 2207;
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String s1 = ";" + studentCode + ";" + qCode;
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress, port);
        socket.send(dp1);
        // requestId;10;2,3,5,6,5
        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, port);
        socket.receive(dp2);

        String s2 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        String[] arr = s2.split(";");
        String id = arr[0] + ";";
        int n = Integer.parseInt(arr[1]);
        String cont = arr[2];
        String[] arr2 = cont.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : arr2)
        {
            int t = Integer.parseInt(s);
            arrayList.add(t);
        }
        for (int i = 1; i <= n; i++)
        {
            if (!arrayList.contains(i))
            {
                id += i + ",";
            }
        }
        id = id.substring(0, id.length() - 1);
        byte[] b3 = id.getBytes();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        socket.send(dp3);
    }
}
