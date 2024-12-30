/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class CharacterGiaiMa {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        
        String s = (String) characterService.requestCharacter("B21DCCN129", "vJhZeOv7");
        System.out.println(s);
        
        int dich = (s.length()) - (s.length() / 7) * 7;
        System.out.println(s.length());
        System.out.println(dich);
        String ans = "";
        for (char c : s.toCharArray())
        {
            if (Character.isLowerCase(c))
            {
                char cnew = (char)((c - 'a' - dich + 26) % 26 + 'a');
                ans += cnew;
            }
            else
            {
                char cnew = (char)((c - 'A' - dich + 26) % 26 + 'A');
                ans += cnew;
            }
                
        }
        System.out.println(ans);
        characterService.submitCharacter("B21DCCN129", "vJhZeOv7", ans);
        
    }
    
}
