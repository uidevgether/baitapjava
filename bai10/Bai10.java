package bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai10 {
    private static List<Product> danhSachSanPham = new ArrayList<>();
    private static List<OrderItem> hoaDon = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo sẵn một số sản phẩm làm dữ liệu mẫu
        khoiTaoSanPhamMau();

        int choice;
        do {
            System.out.println("\n========== HỆ THỐNG BÁN HÀNG ĐƠN GIẢN ==========");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào hóa đơn");
            System.out.println("3. Xem hóa đơn & Tính tổng tiền");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    hienThiSanPham();
                    break;
                case 2:
                    themVaoHoaDon();
                    break;
                case 3:
                    hienThiHoaDon();
                    break;
                case 0:
                    System.out.println("Đã thoát hệ thống!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void khoiTaoSanPhamMau() {
        danhSachSanPham.add(new Product("SP01", "Laptop Lenovo", 15000000));
        danhSachSanPham.add(new Product("SP02", "Chuột Logitech", 350000));
        danhSachSanPham.add(new Product("SP03", "Bàn phím cơ", 850000));
    }

    private static void hienThiSanPham() {
        System.out.println("\n---------------- DANH SÁCH SẢN PHẨM ----------------");
        System.out.printf("| %-10s | %-20s | %-12s |\n", "Mã SP", "Tên SP", "Giá (VNĐ)");
        System.out.println("----------------------------------------------------");
        for (Product p : danhSachSanPham) {
            System.out.printf("| %-10s | %-20s | %-12.0f |\n", p.getMaSP(), p.getTenSP(), p.getGia());
        }
        System.out.println("----------------------------------------------------");
    }

    private static void themVaoHoaDon() {
        hienThiSanPham();
        System.out.print("Nhập mã sản phẩm cần mua: ");
        String ma = scanner.nextLine().trim();

        Product selectedProduct = null;
        for (Product p : danhSachSanPham) {
            if (p.getMaSP().equalsIgnoreCase(ma)) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Mã sản phẩm không tồn tại!");
            return;
        }

        System.out.print("Nhập số lượng mua: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        if (soLuong <= 0) {
            System.out.println("Số lượng mua phải lớn hơn 0!");
            return;
        }

        hoaDon.add(new OrderItem(selectedProduct, soLuong));
        System.out.println("=> Đã thêm " + soLuong + " " + selectedProduct.getTenSP() + " vào hóa đơn!");
    }

    private static void hienThiHoaDon() {
        if (hoaDon.isEmpty()) {
            System.out.println("\nHóa đơn hiện tại chưa có sản phẩm nào!");
            return;
        }

        System.out.println("\n====================== HÓA ĐƠN BÁN HÀNG ======================");
        System.out.printf("| %-20s | %-10s | %-10s | %-12s |\n", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền");
        System.out.println("--------------------------------------------------------------");

        double tongTien = 0;
        for (OrderItem item : hoaDon) {
            double thanhTien = item.getThanhTien();
            tongTien += thanhTien;
            System.out.printf("| %-20s | %-10.0f | %-10d | %-12.0f |\n",
                    item.getProduct().getTenSP(), item.getProduct().getGia(), item.getSoLuong(), thanhTien);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("TỔNG TIỀN HÓA ĐƠN: %,.0f VNĐ\n", tongTien);
        System.out.println("==============================================================");
    }
}