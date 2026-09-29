package bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai9 {
    private static List<Student> danhSachSV = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========== QUẢN LÝ ĐIỂM THEO MÔN HỌC ==========");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Thêm / Sửa điểm môn học cho sinh viên");
            System.out.println("3. Hiển thị danh sách sinh viên & điểm trung bình");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    themSuaDiem();
                    break;
                case 3:
                    hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void themSinhVien() {
        System.out.print("Nhập mã sinh viên: ");
        String ma = scanner.nextLine().trim();
        System.out.print("Nhập tên sinh viên: ");
        String ten = scanner.nextLine().trim();

        danhSachSV.add(new Student(ma, ten));
        System.out.println("=> Thêm sinh viên thành công!");
    }

    private static Student timSinhVien(String maSV) {
        for (Student sv : danhSachSV) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }

    private static void themSuaDiem() {
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống!");
            return;
        }

        System.out.print("Nhập mã sinh viên cần nhập/sửa điểm: ");
        String ma = scanner.nextLine().trim();
        Student sv = timSinhVien(ma);

        if (sv == null) {
            System.out.println("Không tìm thấy sinh viên có mã " + ma);
            return;
        }

        System.out.print("Nhập tên môn học: ");
        String mon = scanner.nextLine().trim();
        System.out.print("Nhập điểm môn " + mon + ": ");
        double diem = Double.parseDouble(scanner.nextLine());

        sv.nhapHoacSuaDiem(mon, diem);
        System.out.println("=> Cập nhật điểm thành công cho sinh viên " + sv.getTenSV());
    }

    private static void hienThiDanhSach() {
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        System.out.println("\n---------------- DANH SÁCH SINH VIÊN ----------------");
        for (Student sv : danhSachSV) {
            sv.hienThiThongTin();
        }
        System.out.println("------------------------------------------------------");
    }
}