import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        // 1. Nhập danh sách n số nguyên
        System.out.print("Nhập số lượng phần tử n: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        // 2. In danh sách theo thứ tự nhập
        System.out.println("\n--- 1. Danh sách theo thứ tự nhập ---");
        System.out.println(numbers);

        // 3. In danh sách tăng dần
        // Tạo một bản sao để sắp xếp không làm thay đổi thứ tự ban đầu nếu cần
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println("\n--- 2. Danh sách sắp xếp tăng dần ---");
        System.out.println(sortedNumbers);

        // 4. Tính trung bình cộng, phần tử lớn nhất, nhỏ nhất
        if (!numbers.isEmpty()) {
            int sum = 0;
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);

            for (int num : numbers) {
                sum += num;
            }
            double avg = (double) sum / numbers.size();

            System.out.println("\n--- 3. Thống kê ---");
            System.out.println("Trung bình cộng: " + avg);
            System.out.println("Phần tử lớn nhất: " + max);
            System.out.println("Phần tử nhỏ nhất: " + min);
        }

        // 5. Xóa tất cả các số chẵn dùng Iterator
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current % 2 == 0) {
                iterator.remove(); // Xóa an toàn không gây ConcurrentModificationException
            }
        }

        System.out.println("\n--- 4. Danh sách sau khi xóa tất cả số chẵn ---");
        System.out.println(numbers);

        scanner.close();
    }
}