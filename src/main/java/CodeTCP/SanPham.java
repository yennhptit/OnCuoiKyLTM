package CodeTCP;

import TCP.Product;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SanPham {
    public static void main(String[] args) throws Exception{
//        Socket socket = new Socket("203.162.10.109", 2209);
//        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//
//        String s1 = "B21DCCN311;IJtoXzEQ";
//        oos.writeObject(s1);
//        oos.flush();
//
//        TCP.Product product = (Product) ois.readObject();
//        product.changeDiscount();
//
//        oos.writeObject(product);
//
//        oos.flush();
//        oos.close();
//        ois.close();
//        socket.close();
     //   code chuyển mảng byte[] về ArrayList
        byte[] byteArray = {65, 66, 67, 68, 69};  // Các giá trị ASCII cho A, B, C, D, E

        List<Integer> intList = new ArrayList<>();
        for (byte b : byteArray) {
            intList.add((int) b);  // Chuyển byte thành Integer và thêm vào ArrayList
        }
        System.out.println("ArrayList<Integer>: " + intList);

    }
}
