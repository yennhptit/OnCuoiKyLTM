/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import RMI.CharacterService;
import java.net.Socket;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class MaHoa {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        String studentCode = "B21DCCN001";
        String qCode = "AhrzRLmM";

        String s2 = (String) characterService.requestCharacter(studentCode, qCode);
        String ans = "";

        String[] arr = s2.split(" ");
        for (String s : arr) {
            for (char charac : s.toCharArray()) {
                
                if (Character.isLetter(charac) || Character.isDigit(charac) || charac == '*') {
                    ans += charac;
                } else {
                    int code = Integer.valueOf(charac);
                    ans += "%" + Integer.toHexString(code).toUpperCase();
                }
            }
            ans += "+";
        }
        ans = ans.substring(0, ans.length() - 1);
        characterService.submitCharacter(studentCode, qCode, ans);

    }
}
