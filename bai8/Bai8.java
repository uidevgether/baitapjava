package bai8;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Bai8 {
    public static void main(String[] args) {
        // Sử dụng Comparator để sắp xếp PriorityQueue giảm dần theo doUuTien (Số lớn ưu tiên trước)
        PriorityQueue<YeuCau> hangDoiUuTien = new PriorityQueue<>(new Comparator<YeuCau>() {
            @Override
            public int compare(YeuCau y1, YeuCau y2) {
                return Integer.compare(y2.getDoUuTien(), y1.getDoUuTien());
            }
        });

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng yêu cầu muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin yêu cầu thứ " + (i + 1) + " ---");
            System.out.print("Nhập ID yêu cầu: ");
            String id = scanner.nextLine().trim();

            System.out.print("Nhập mô tả công việc: ");
            String moTa = scanner.nextLine().trim();

            System.out.print("Nhập mức độ ưu tiên (số nguyên, ví dụ 1:Thường, 5:Gấp, 10:Khẩn cấp): ");
            int doUuTien = Integer.parseInt(scanner.nextLine());

            hangDoiUuTien.add(new YeuCau(id, moTa, doUuTien));
        }

        // In danh sách xử lý theo thứ tự mức độ ưu tiên
        System.out.println("\n================ DANH SÁCH XỬ LÝ THEO THỨ TỰ ƯU TIÊN ================");
        int stt = 1;
        while (!hangDoiUuTien.isEmpty()) {
            // poll() sẽ lấy ra yêu cầu có độ ưu tiên cao nhất còn lại trong hàng đợi
            YeuCau yc = hangDoiUuTien.poll();
            System.out.println("Xử lý " + stt + " -> " + yc);
            stt++;
        }

        scanner.close();
    }
}
