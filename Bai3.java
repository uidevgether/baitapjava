import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // HashSet tự động loại bỏ các phần tử trùng lặp
        Set<String> phoneNumbers = new HashSet<>();

        System.out.print("Nhập số lượng số điện thoại muốn nhập: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số điện thoại thứ " + (i + 1) + ": ");
            String phone = scanner.nextLine().trim();
            phoneNumbers.add(phone);
        }

        System.out.println("\n--- DANH SÁCH SỐ ĐIỆN THOẠI (ĐÃ LOẠI BỎ TRÙNG LẶP) ---");
        for (String phone : phoneNumbers) {
            System.out.println("- " + phone);
        }

        scanner.close();
    }
}
