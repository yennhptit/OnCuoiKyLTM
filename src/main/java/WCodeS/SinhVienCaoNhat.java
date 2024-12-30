package WCodeS;

import vn.medianews.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinhVienCaoNhat {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN042";
        String qCode = "ymCxkkOG";
//        int port = 2209;
        String host = "203.162.10.109";

        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        List<StudentY> list = port.requestListStudentY(studentCode, qCode);

        ArrayList<String> listMon = new ArrayList<>();



        for (StudentY studentY : list)
        {
            String tmp = studentY.getSubject();
            if(!listMon.contains(tmp))
            {
                listMon.add(tmp);
            }
        }
        List<StudentY> ans = new ArrayList<>();
        for (String s : listMon)
        {
            StudentY t = change(list, s);
            ans.add(t);
        }
        List<StudentY> kq = new ArrayList<>();
        {
            for (StudentY studentY2 : list)
            {
                for (StudentY tmp : ans)
                {
                    if (studentY2.getStudentId().equals(tmp.getStudentId()))
                    {
                        kq.add(studentY2);
                        break;
                    }
                }
            }
        }
        port.submitListStudentY(studentCode, qCode, kq);
    }
    public static StudentY change(List<StudentY> list, String mon)
    {
        StudentY studentY1 = null;
        float max = -1;
        for (StudentY studentY2 : list)
        {
            if (studentY2.getSubject().equals(mon))
            {
                if (studentY2.getScore() > max)
                {
                    max = studentY2.getScore();
                    studentY1 = studentY2;
                }
            }
        }
        return studentY1;
    }
}
