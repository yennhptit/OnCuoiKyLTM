/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author Admin
 */
public class NguyenAmMaxMin {
    public static void main(String[] args) throws Exception{
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        
        String studentCode = "B21DCCN010";
        String qCode = "sGJc3iD5";
        List<String> list = port.requestStringArray(studentCode, qCode);
        Collections.sort(list, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        String s = list.get(list.size() - 1) + ";"+ list.get(0);
        port.submitCharacterString(studentCode, qCode, s);
    }
    public static int countnguyenam(String s)
    {
        int cnt = 0;
        s = s.toLowerCase();
        for (char c :  s.toCharArray())
        {
            if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o')
                cnt++;
        }
        return cnt;
    }
}
