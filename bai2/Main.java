package bai2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> danhSachSV = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n================= MENU QUẢN LÝ SINH VIÊN =================");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên theo dạng bảng");
            System.out.println("3. Tìm sinh viên theo mã");
            System.out.println("4. Sắp xếp danh sách theo điểm kết thúc học phần giảm dần");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-4): ");
            
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    hienThiDanhSach(danhSachSV);
                    break;
                case 3:
                    timSinhVienTheoMa();
                    break;
                case 4:
                    sapXepDiemGiamDan();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (choice != 0);
    }

    // 1. Thêm sinh viên
    private static void themSinhVien() {
        System.out.println("\n--- THÊM MỚI SINH VIÊN ---");
        System.out.print("Nhập mã sinh viên: ");
        String maSV = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhập điểm chuyên cần (CC): ");
        double diemCC = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập điểm kiểm tra (KT): ");
        double diemKT = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập điểm bài tập lớn (BTL): ");
        double diemBTL = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập điểm thi: ");
        double diemThi = Double.parseDouble(scanner.nextLine());

        Student student = new Student(maSV, hoTen, gioiTinh, diemCC, diemKT, diemBTL, diemThi);
        danhSachSV.add(student);
        System.out.println("=> Thêm sinh viên thành công!");
    }

    // 2. Hiển thị danh sách dạng bảng
    private static void hienThiDanhSach(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống!");
            return;
        }

        System.out.println("\n================================================ DANH SÁCH SINH VIÊN ================================================");
        System.out.printf("| %-10s | %-20s | %-8s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s |\n",
                "Mã SV", "Họ Tên", "Giới Tính", "Đ.CC", "Đ.KT", "Đ.BTL", "Đ.QT", "Đ.Thi", "Đ.KTHP");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        
        for (Student st : list) {
            st.hienThiRow();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    // 3. Tìm sinh viên theo mã
    private static void timSinhVienTheoMa() {
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống!");
            return;
        }

        System.out.print("\nNhập mã sinh viên cần tìm: ");
        String maTim = scanner.nextLine();
        boolean timThay = false;

        for (Student st : danhSachSV) {
            if (st.getMaSV().equalsIgnoreCase(maTim)) {
                System.out.println("\n=> Kết quả tìm kiếm:");
                System.out.printf("| %-10s | %-20s | %-8s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s |\n",
                        "Mã SV", "Họ Tên", "Giới Tính", "Đ.CC", "Đ.KT", "Đ.BTL", "Đ.QT", "Đ.Thi", "Đ.KTHP");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                st.hienThiRow();
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sinh viên có mã: " + maTim);
        }
    }

    // 4. Sắp xếp theo điểm kết thúc học phần giảm dần (Sử dụng Comparator)
    private static void sapXepDiemGiamDan() {
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống!");
            return;
        }

        Collections.sort(danhSachSV, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getDiemKTHocPhan(), s1.getDiemKTHocPhan());
            }
        });

        System.out.println("\n=> Đã sắp xếp danh sách theo điểm kết thúc học phần giảm dần!");
        hienThiDanhSach(danhSachSV);
    }
}