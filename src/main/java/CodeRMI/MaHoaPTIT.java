package CodeRMI;

import RMI.ByteService;
import RMI.CharacterService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaHoaPTIT {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN042";
        String qCode = "bGCeEyi5";
        int port = 2209;
        String host = "203.162.10.109";

        Registry registry = LocateRegistry.getRegistry(host);
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String s1 = service.requestCharacter(studentCode, qCode);
        String[] arr = s1.split(";");
        String key = arr[0].trim();
        String content = arr[1].trim();
        String newKey= "";
        int lap = 0;
        lap = content.length() / key.length() * key.length();
        if (key.length() * lap < content.length())
        {
            lap += 1;
        }
        for (int i = 0; i < lap; i ++)
        {
            newKey += key;
        }
        String ans = "";
        for (int i = 0; i < content.length(); i++)
        {
            char c = content.charAt(i);
            String s = String.valueOf(c);
            char k = newKey.charAt(i);
            if (Character.isUpperCase(c))
            {
                int newIndex = (int) (c - 'A' + k - 'A') % 26 + 'A';
                ans += (char) newIndex;
            }
            else {
                int newIndex = (int) (c - 'a' + k - 'a') % 26 + 'a';
                ans += (char) newIndex;
            }
        }
        service.submitCharacter(studentCode, qCode, ans);
    }
}
