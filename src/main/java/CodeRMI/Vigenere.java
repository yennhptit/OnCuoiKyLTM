/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeRMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.*;

/**
 *
 * @author Admin
 */
public class Vigenere {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");
        
        String studentCode = "B21DCCN008";
        String qCode = "8hwuvEkT";
        String s1 = service.requestCharacter(studentCode, qCode);
        String[] arr = s1.split(";");
        String key = arr[0];
        String cont = arr[1];
        int lap = 0;
        String newKey = "";
        if (cont.length() > key.length())
        {
            int t = cont.length() / key.length() * key.length();
            if (t == cont.length())
            {
                lap = t;
            }
            else lap = t + 1;
        }
        for (int i = 0 ; i < lap; i++)
        {
            newKey += key;
        }
//        newKey = newKey.substring(0, cont.length());
        String ans = "";
        for (int i = 0; i < cont.length(); i++)
        {
            char c = cont.charAt(i);
            char k = newKey.charAt(i);
            if (Character.isUpperCase(c))
            {
                int d1 = (int) k - (int) 'A';
                int newindex1 = ((int) c - (int)'A' + d1) % 26 + (int) 'A';
                ans += (char) newindex1;
            }
            else
            {
                int d1 = (int) k - (int) 'a';
                int newindex1 = ((int) c - (int) 'a' + d1) % 26 + (int) 'a';
                ans += (char) newindex1;
            }
        }
        service.submitCharacter(studentCode, qCode, ans);
    }
}

