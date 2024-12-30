/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.Port;
import javax.xml.datatype.XMLGregorianCalendar;
import vn.medianews.*;

/**
 *
 * @author Admin
 */
public class YeuCau {
    public static void main(String[] args) throws Exception{
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = (ObjectService) service.getObjectServicePort();
        
        String studentCode = "B21DCCN008";
        String qCode = "46WF6Fg5";
        List<OrderY> o = port.requestListOrderY(studentCode, qCode);
        
        List<OrderY> orderYs = new ArrayList<>();
        for (OrderY oy : o)
        {
            if (oy.getStatus().equalsIgnoreCase("pending") || oy.getStatus().equalsIgnoreCase("processing"))
            {
                XMLGregorianCalendar orderDate = oy.getOrderDate();
                LocalDate toDay = LocalDate.now();
                LocalDate orderDate1 = orderDate.toGregorianCalendar().toZonedDateTime().toLocalDate();
                Period period = Period.between(orderDate1, toDay);
                long day = ChronoUnit.DAYS.between(orderDate1, toDay);
                int month = period.getMonths();
                System.out.println(orderDate1);
                System.out.println(month);

                System.out.println(day);
                if (day > 30)
                {
                    orderYs.add(oy);
                }
            }
        }
        port.submitListOrderY(studentCode, qCode, orderYs);
    }
}
