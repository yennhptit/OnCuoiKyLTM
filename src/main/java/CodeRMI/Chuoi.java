package CodeRMI;

import RMI.ByteService;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Chuoi {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN042";
        String qCode = "FMz4oZPA";
        int port = 2209;
        String host = "203.162.10.109";

        Registry registry = LocateRegistry.getRegistry(host);
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        byte[] b1 = service.requestData(studentCode, qCode);
        String s1 = new String(b1, 0, b1.length).trim();
        // [72, 101, 108, 108, 111] sang Hello;
//        String[] arr = s1.split(",");
//        String ans = "";
        List<String> list = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(s1.length() * 2);
        for (char s : s1.toCharArray())
        {
            int t = (int) s;
            String str = Integer.toHexString(t);
            System.out.println(str);
            buffer.put(str.getBytes());
        }
        service.submitData(studentCode, qCode, buffer.array());

    }
}
