/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;

/**
 *
 * @author Admin
 */
public class XoayVong {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN129";
        String qCode = "WvzZ0fWr";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        
        List<Integer> list = port.requestCharacter(studentCode, qCode);
        System.out.println(list);
        int dich = list.get(0) - list.get(0) / list.size() * list.size();
        Collections.rotate(list, dich);
        port.submitCharacterCharArray(studentCode, qCode, list);
                
    }
}
