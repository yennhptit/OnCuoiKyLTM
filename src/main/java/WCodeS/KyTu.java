/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WCodeS;

import vn.medianews.*;

/**
 *
 * @author Admin
 */
public class KyTu {

    public static void main(String[] args) throws Exception {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        String studentCode = "B21DCCN008";
        String qCode = "rT6Ql5GH";
//       Loại bỏ tất cả các ký tự đặc biệt, số, chỉ các ký tự chữ cái.
//•	Đảo ngược chuỗi kết quả sau khi đã loại bỏ các ký tự đặc biệt.
        String s1 = port.requestString(studentCode, qCode);
        System.out.println(s1);
        String c2 = "";
        String clean = "";
        for (char c : s1.toCharArray())
        {
            if (Character.isLetter(c))
            {
                c2 += c;
            }
        }
        for (int i = c2.length()- 1; i >= 0; i--)
        {
            clean += c2.charAt(i);
        }
        port.submitCharacterString(studentCode, qCode, clean);
    }
}