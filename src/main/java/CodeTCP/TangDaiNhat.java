package CodeTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TangDaiNhat {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN001";
        String qCode = "XGIm2Fc7";
        int port = 2206;
        String host = "203.162.10.109";

        Socket socket = new Socket(host, port);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

//        String s1 = studentCode + ";" + qCode;
//        byte[] b1 = s1.getBytes();
//        os.write(b1);
//        os.flush();
//
//        byte[] b2 = new byte[1024];
//        int read = is.read(b2);
//        String s2 = new String(b2, 0, b2.length).trim();
        String s2 = "10, 22, 9, 33, 21, 50, 41, 60, 80";

        String[] arr = s2.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : arr)
        {
            list.add(Integer.parseInt(s.trim()));
        }
        int[] L = new int[list.size()];
        int[] prev = new int[10000000];
        Arrays.fill(L, 1);  // nó looon có chính nos
        int max = 0;
        Arrays.fill(prev, -1);
        // phải duyệt i từ 1;
        for (int i = 1; i <= list.size() - 1; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (list.get(i) > list.get(j)) {
                    if (L[j] + 1 > L[i]) {
                        prev[i] = j;
                    }
                    L[i] = Math.max(L[i], L[j] + 1);

                }
            }
        }

        for (int i = 0; i <= L.length - 1; i++)
        {
            max = Math.max(max, L[i]);
        }
        System.out.println(max);
        int index = 0;
        for (int i = 0; i <= L.length -1; i++)
        {
            if (L[i] == max)
            {
                index = i;
            }
        }

        while (index != -1)
        {
            System.out.println(list.get(index));  // in trước xong mới dịch lùi lại
            index = prev[index];


        }
    }
}
