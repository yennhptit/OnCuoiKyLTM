/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.deploy.net.proxy.UserDefinedProxyConfig;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;

/**
 *
 * @author Admin
 */
public class DuAn {
    public static void main(String[] args) throws Exception{
        String qCode = "R6UOuyyE";
        String studentCode = "B21DCCN010";
        
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        
        List<Project> projects = port.requestListProject(studentCode, qCode);
        List<Project> ans = new ArrayList<>();
        for (Project project : projects)
        {
            if (project.getCompletionPercentage() >= 80)
            {
                XMLGregorianCalendar dueDate = project.getDueDate();
                LocalDate dueLocalDate = dueDate.toGregorianCalendar().toZonedDateTime().toLocalDate();
                int day = (int) ChronoUnit.DAYS.between(dueLocalDate, LocalDate.now());
                
                if (day <= 15)
                {
                    ans.add(project);
                }
                
            }
        }
        port.submitListProject(studentCode, qCode, ans);
    }
   
}

