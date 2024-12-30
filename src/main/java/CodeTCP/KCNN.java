package CodeTCP;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KCNN {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN311";
        String qCode = "RIX9tftG";
        String host = "203.162.10.109";
        int port = 2206;

        Socket socket = new Socket(host, port);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String s1 = studentCode + ";" + qCode;
        byte[] b1 = s1.getBytes();
        os.write(b1);
        os.flush();

        byte[] b2 = new byte[1024];
        int read = is.read(b2);
        String s2 = new String(b2, 0, b2.length).trim();
        String[] arr = s2.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : arr)
        {
            int t = Integer.parseInt(s.trim());
            arrayList.add(t);
        }

        Collections.sort(arrayList);
        int min = 1000, a = 0, b = 0;
        for (int i = 1; i < arrayList.size(); i++)
        {
            if (arrayList.get(i) - arrayList.get(i - 1) < min)
            {
                min = arrayList.get(i) - arrayList.get(i - 1);
                a = arrayList.get(i - 1);
                b = arrayList.get(i);
            }
        }
        String s3 = min + "," + a + "," + b;
        os.write(s3.getBytes());
        os.flush();

        os.close();
        is.close();
        socket.close();

    }
}
