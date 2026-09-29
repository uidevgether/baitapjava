package bai2;
public class Student {
    private String maSV;
    private String hoTen;
    private String gioiTinh;
    private double diemCC;  // Điểm chuyên cần
    private double diemKT;  // Điểm kiểm tra
    private double diemBTL; // Điểm bài tập lớn
    private double diemThi; // Điểm thi

    // Constructor đầy đủ tham số
    public Student(String maSV, String hoTen, String gioiTinh, double diemCC, double diemKT, double diemBTL, double diemThi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemBTL = diemBTL;
        this.diemThi = diemThi;
    }

    // Getter cho mã sinh viên
    public String getMaSV() {
        return maSV;
    }

    // Công thức tính điểm quá trình theo đề bài: (điểm CC + 2*điểm KT + 3*điểm BTL) / 6
    public double getDiemQuaTrinh() {
        return (diemCC + 2 * diemKT + 3 * diemBTL) / 6.0;
    }

    // Công thức tính điểm kết thúc học phần theo đề bài: (điểm quá trình + điểm thi) / 2
    public double getDiemKTHocPhan() {
        return (getDiemQuaTrinh() + diemThi) / 2.0;
    }

    // Phương thức in thông tin theo dạng dòng chuẩn bảng
    public void hienThiRow() {
        System.out.printf("| %-10s | %-20s | %-8s | %-6.1f | %-6.1f | %-6.1f | %-6.1f | %-6.1f | %-6.1f |\n",
                maSV, hoTen, gioiTinh, diemCC, diemKT, diemBTL, getDiemQuaTrinh(), diemThi, getDiemKTHocPhan());
    }
}