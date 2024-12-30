package CodeTCP;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class DayConTangDaiNhat {
    public static void main(String[] args) throws Exception {
        // Kết nối đến server
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

//         Gửi mã sinh viên và mã câu hỏi
        String s1 = "B21DCCN001;XGIm2Fc7";
        os.write(s1.getBytes());
        os.flush();

        // Nhận dữ liệu từ server
        byte[] b2 = new byte[1024];
        int read = is.read(b2);
        String s2 = new String(b2, 0, read).trim();
//        String s2 = "169811,144848,254679,180345,165914,435828,441033,349327,173869,76414,219065,123440,144822,260796,213510,263501,121385,56974,310541,306342,383329,61618,220142,294567,170101,451805,177974,165352,344866,168789,299257,173747,136189,143851,44995,351418,315261,350990,212060,62945,41603,384658,297974,437199,305392,460432,374036,17058,104137,260527,433193,382136,413809,96936,354865,450218,1707,436271,316552,99555,231306,280557,242277,256446,245328,193979,39507,231373,11655,295801,80740,317062,310951,422348,424258,251688,367845,120949,276,410923,442500,116382,405201,314757,132826,243040,156844,211993,68434,229625,417980,112715,29657,179009,331318,182182,382143";
        System.out.println("Dữ liệu nhận được: " + s2);

        // Chuyển đổi chuỗi thành mảng số nguyên
        String[] arr = s2.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : arr) {
            arrayList.add(Integer.parseInt(s.trim()));
        }
        int n = arrayList.size();
        Integer[] L = new Integer[arrayList.size()];
        Integer[] prev = new Integer[10000000];
        Arrays.fill(L, 1);
        Arrays.fill(prev, -1);
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arrayList.get(i) > arrayList.get(j))
                {
                    if (L[j] + 1 > L[i])
                    {
                        prev[i] = j;
                    }
                    L[i] = Integer.max(L[i], L[j] + 1);
                    
                }
            }
        }
        int cntMAx = Collections.max(Arrays.asList(L));
        int indexMAx = Arrays.asList(L).indexOf(cntMAx);
        int max = arrayList.get(indexMAx);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(max);
        int curr = indexMAx;
        while (prev[curr] != -1) {
            curr = prev[curr];
            
            ans.add(arrayList.get(curr));
        }
        Collections.reverse(ans);
        String kq = "";
        for (Integer t : ans)
        {
            kq += t + ",";
        }
        kq = kq.substring(0, kq.length() - 1);
        kq += ";" + cntMAx;
        
        os.write(kq.getBytes());
        os.flush();
        
        os.close();
        is.close();
        socket.close();
        
    }
}
