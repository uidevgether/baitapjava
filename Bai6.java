import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào một đoạn văn bản:");
        String text = scanner.nextLine();

        // Chuyển toàn bộ đoạn văn thành chữ thường và tách từ dựa trên khoảng trắng/dấu câu
        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            // Nếu từ đã có trong Map thì tăng số lần xuất hiện lên 1, nếu chưa có thì gán giá trị 1
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n--- SỐ LẦN XUẤT HIỆN CỦA MỖI TỪ ---");
        System.out.printf("| %-20s | %-15s |\n", "Từ", "Số lần xuất hiện");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.printf("| %-20s | %-15d |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("------------------------------------------");

        scanner.close();
    }
}