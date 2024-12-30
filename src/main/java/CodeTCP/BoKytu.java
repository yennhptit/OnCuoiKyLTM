package CodeTCP;

import java.io.*;
import java.net.Socket;

public class BoKytu {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "KspcjMLb";
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String s1 = studentCode + ";" + qCode;
        bw.write(s1);
        bw.newLine();
        bw.flush();

        String s21 = br.readLine();
        String s22 = br.readLine();
        String ans = "";
        for (char c : s21.toCharArray())
        {
            String s = String.valueOf(c);
            if (!s22.contains(s))
            {
                ans += s;
            }
        }
        bw.write(ans);
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
    }
}
