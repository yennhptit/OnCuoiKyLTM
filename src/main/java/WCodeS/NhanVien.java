/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import vn.medianews.*;
import vn.medianews.DataService_Service;

/**
 *
 * @author Admin
 */
public class NhanVien {

    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN129";
        String qCode = "4TTzyjPu";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        Employee employee = (Employee) port.requestEmployee(studentCode, qCode);
        
        XMLGregorianCalendar start = employee.getStartDate();
        XMLGregorianCalendar end = employee.getEndDate();
        LocalDate starDate = start.toGregorianCalendar().toZonedDateTime().toLocalDate();
        LocalDate enDate = end.toGregorianCalendar().toZonedDateTime().toLocalDate();
        System.out.println(starDate);
        System.out.println(enDate);

        int cnt = 0;
        for (LocalDate i = starDate; !i.isAfter(enDate); i = i.plusDays(1)) {
            System.out.println(i);
            if (i.getDayOfWeek() != DayOfWeek.SUNDAY && i.getDayOfWeek() != DayOfWeek.SATURDAY) {
                cnt += 1;
                System.out.println(i.getDayOfWeek());
                System.out.println(cnt);
            }
        }
        employee.setWorkingDays(cnt);
        port.submitEmployee(studentCode, qCode, employee);
    }
}
