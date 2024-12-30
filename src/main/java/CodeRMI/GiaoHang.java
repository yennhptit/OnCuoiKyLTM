package CodeRMI;

import RMI.CharacterService;
import RMI.ObjectService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GiaoHang {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN042";
        String qCode = "K6QQOTpL";
        int port = 2209;
        String host = "203.162.10.109";

        Registry registry = LocateRegistry.getRegistry(host);
        ObjectService service = (ObjectService) registry.lookup("RMIObjectService");

        RMI.Order order = ( RMI.Order)service.requestObject(studentCode, qCode);
        order.changeorderCode();
        System.out.println(order.getOrderCode());
        service.submitObject(studentCode, qCode, order);
    }
}
