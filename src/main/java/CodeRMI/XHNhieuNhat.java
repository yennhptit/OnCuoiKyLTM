package CodeRMI;

import RMI.ByteService;

import java.nio.ByteBuffer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XHNhieuNhat {
    public static void main(String[] args) {
        try {
            // Kết nối tới RMI registry của server
            Registry registry = LocateRegistry.getRegistry("203.162.10.109");
            ByteService service = (ByteService) registry.lookup("RMIByteService");

            // Triệu gọi phương thức requestData để nhận dữ liệu
            byte[] data = service.requestData("B21DCCN311", "8WKB2Fue");

            // Chuyển đổi dữ liệu nhị phân thành chuỗi các số nguyên
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (byte b : data) {
                arrayList.add((int) b);
            }

            // Tìm phần tử xuất hiện nhiều nhất
            int mostFrequentElement = findMostFrequentElement(arrayList);

            // Chuyển phần tử phổ biến nhất và tần suất xuất hiện thành dữ liệu nhị phân
            int frequency = countOccurrences(arrayList, mostFrequentElement);
            String frequencyStr = String.valueOf(frequency);
            String elementStr = String.valueOf(mostFrequentElement);

            // Tạo ByteBuffer chứa dữ liệu để gửi lại server
            ByteBuffer buffer = ByteBuffer.allocate(frequencyStr.getBytes().length + elementStr.getBytes().length);
            buffer.put(elementStr.getBytes());
            buffer.put(frequencyStr.getBytes());

            // Triệu gọi phương thức submitData để gửi kết quả về server
            service.submitData("B21DCCN311", "8WKB2Fue", buffer.array());

            System.out.println("Đã gửi dữ liệu về server: " + mostFrequentElement + " với tần suất: " + frequency);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức tìm phần tử xuất hiện nhiều nhất
    public static int findMostFrequentElement(ArrayList<Integer> arrayList) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arrayList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequent = arrayList.get(0);
        int maxFrequency = 0;

        // Tìm phần tử có tần suất cao nhất
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequent = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequent;
    }

    // Phương thức đếm số lần xuất hiện của phần tử
    public static int countOccurrences(ArrayList<Integer> arrayList, int element) {
        int count = 0;
        for (int num : arrayList) {
            if (num == element) {
                count++;
            }
        }
        return count;
    }
}
