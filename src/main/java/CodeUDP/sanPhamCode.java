package CodeUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class sanPhamCode {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "ZAqp3rEO";
        int port = 2209;
        String host = "203.162.10.109";

        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName(host);

        String s = ";" + studentCode + ";" + qCode;
        DatagramPacket dp1 = new DatagramPacket(s.getBytes(), 0, s.length(), inetAddress, port);
        socket.send(dp1);

        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, 0, b2.length, inetAddress, port);
        socket.receive(dp2);

        byte[] b2new = dp2.getData();
        byte[] b21 = new byte[8];
        byte[] b22 = new byte[b2new.length - 8];

        System.arraycopy(b2new, 0, b21, 0, 8);
        System.arraycopy(b2new, 8, b22, 0, b2new.length - 8);

        ByteArrayInputStream bais = new ByteArrayInputStream(b22);
        ObjectInputStream ois = new ObjectInputStream(bais);
        UDP.Product product = (UDP.Product) ois.readObject();

        product.changeName();
        product.changeQua();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(product);
        oos.flush();

        byte[] pro = baos.toByteArray();

        ByteBuffer buffer = ByteBuffer.allocate(b21.length + pro.length);
        buffer.put(b21);
        buffer.put(pro);
        byte[] b3 = buffer.array();
        DatagramPacket dp3 = new DatagramPacket(b3, 0, b3.length, inetAddress, port);
        socket.send(dp3);
    }
}
