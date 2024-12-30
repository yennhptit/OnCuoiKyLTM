package CodeTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DayConTangMax {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "H3AS0cX7";
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String s1 = studentCode + ";" + qCode;
        os.write(s1.getBytes());
        os.flush();

        byte[] b2 = new byte[1024];
        int read = is.read(b2);
        String s2 = new String(b2, 0, b2.length).trim();
        String tmp = "";
        String kq = "";
        for (char c : s2.toCharArray())
        {
            String s = String.valueOf(c);
            while (tmp.contains(s))
            {
                tmp = tmp.substring(1);
            }
            tmp += s;
            if (tmp.length() > kq.length())
            {
                kq = tmp;
            }
        }
        String s3 = kq + ";" + kq.length();
        os.write(s3.getBytes());
        os.flush();
        os.close();
        is.close();
        socket.close();
    }
}
