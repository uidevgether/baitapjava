import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai7 {
    private static Queue<String> hangDoi = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int soThuTuAuto = 1; // Tự động phát số thứ tự

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========== HỆ THỐNG LẤY SỐ KHÁM BỆNH ==========");
            System.out.println("1. Lấy số thứ tự (Thêm bệnh nhân)");
            System.out.println("2. Xem bệnh nhân sẽ được phục vụ tiếp theo");
            System.out.println("3. Gọi phục vụ (Gọi vào khám)");
            System.out.println("4. Hiển thị toàn bộ hàng đợi");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    laySoThuTu();
                    break;
                case 2:
                    xemTiepTheo();
                    break;
                case 3:
                    goiPhucVu();
                    break;
                case 4:
                    hienThiHangDoi();
                    break;
                case 0:
                    System.out.println("Đã thoát hệ thống!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (choice != 0);
    }

    // 1. Lấy số thứ tự
    private static void laySoThuTu() {
        System.out.print("Nhập tên bệnh nhân: ");
        String ten = scanner.nextLine().trim();
        String thongTin = "STT " + soThuTuAuto + " - " + ten;
        
        hangDoi.add(thongTin); // Thêm vào cuối hàng đợi
        System.out.println("=> Đã cấp số thành công: [" + thongTin + "]");
        soThuTuAuto++;
    }

    // 2. Xem ai tiếp theo
    private static void xemTiepTheo() {
        if (hangDoi.isEmpty()) {
            System.out.println("=> Hiện tại không có bệnh nhân nào trong hàng đợi!");
        } else {
            // peek() lấy phần tử đầu hàng đợi nhưng không xóa
            System.out.println("=> Bệnh nhân sẽ được phục vụ tiếp theo: [" + hangDoi.peek() + "]");
        }
    }

    // 3. Phục vụ bệnh nhân
    private static void goiPhucVu() {
        if (hangDoi.isEmpty()) {
            System.out.println("=> Hàng đợi trống, không có bệnh nhân để phục vụ!");
        } else {
            // poll() lấy phần tử đầu hàng đợi và xóa khỏi hàng đợi
            String benhNhan = hangDoi.poll();
            System.out.println("=> Đang khám/phục vụ bệnh nhân: [" + benhNhan + "]");
        }
    }

    // 4. Hiển thị danh sách chờ
    private static void hienThiHangDoi() {
        if (hangDoi.isEmpty()) {
            System.out.println("=> Hàng đợi hiện đang trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH BỆNH NHÂN ĐANG CHỜ ---");
        int stt = 1;
        for (String bn : hangDoi) {
            System.out.println(stt + ". " + bn);
            stt++;
        }
    }
}