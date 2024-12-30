package WCodeS;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

import java.util.ArrayList;
import java.util.List;

public class SoNguyenTo {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "qp6ocX8b";
//        int port = 2209;
        String host = "203.162.10.109";

        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();

        List<Integer> list = port.getData(studentCode, qCode);
        List<String> stringList = new ArrayList<>();
        for (int i : list)
        {
            String tmp = phantichSoNguyenTo(i);
            stringList.add(tmp);
        }
        port.submitDataStringArray(studentCode, qCode, stringList);
    }
    public static String phantichSoNguyenTo(int n)
    {
        String ans = "";
        int cnt = 0;
        String kq2 = "";
        while (n % 2 == 0)
        {
            n /= 2;
            ans += "2" + ", ";
            cnt++;
        }
        if (cnt > 0)
            kq2 += "2^" + cnt + "*";
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            cnt = 0;
            while (n % i == 0)
            {
                n /= i;
                ans += i + ", ";
                cnt++;
            }
            if (cnt > 0)
                kq2 += i + "^" + cnt + "*";
        }
        if (n > 2) {
            ans += n + ", ";
            kq2 += n + "^1";
        }
        if (ans.endsWith(", "))
            ans = ans.substring(0, ans.length() - 2);
        if (ans.endsWith("*"))
            ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        System.out.println(kq2);
        return ans;
    }
}
