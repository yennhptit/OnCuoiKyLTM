/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTCP;

import java.io.*;
import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientMaHoaCesar {

    public static void main(String[] args) throws Exception {
        int[] arr = {2, 1, 3, 5, 4, 7, 8, 2, 3, 4, 5, 1, 6};
        int left = 0;
        int start = 0;
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] <= arr[left -1])
            {
                start = right;
            }
            if (right - left + 1 > max)
            {
                max = right - left + 1;
                maxStart = left;
                maxEnd = right;
            }
        }
        
        
    }
}
