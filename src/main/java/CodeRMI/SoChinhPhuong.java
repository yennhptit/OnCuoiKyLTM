package CodeRMI;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SoChinhPhuong {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "UdAbSWlM";
        int port = 2209;
        String host = "203.162.10.109";

        Registry registry = LocateRegistry.getRegistry(host);
        DataService service = (DataService) registry.lookup("RMIDataService");

        int s = (int)service.requestData(studentCode, qCode);
        System.out.println(s);

        int sqrt = (int) Math.sqrt(s);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++)
        {
            ans.add(i * i);
        }
        service.submitData(studentCode, qCode, ans);
    }
}
