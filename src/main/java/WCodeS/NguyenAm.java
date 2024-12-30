/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

/**
 *
 * @author Admin
 */
public class NguyenAm {

    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN001";
        String qCode = "mDN1MFUJ";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        List<String> a = port.requestStringArray(studentCode, qCode);
        
        a.sort((s1,s2) -> countVowels(s1) - countVowels(s2));
        
        port.submitCharacterStringArray(studentCode, qCode, a);
        
        
        
    }
    public static int countVowels(String word) {
        int count = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
