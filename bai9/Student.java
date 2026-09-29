package bai9;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String maSV;
    private String tenSV;
    private Map<String, Double> diemMonHoc;

    public Student(String maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diemMonHoc = new HashMap<>();
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public Map<String, Double> getDiemMonHoc() {
        return diemMonHoc;
    }

    // Thêm hoặc sửa điểm môn học
    public void nhapHoacSuaDiem(String monHoc, double diem) {
        diemMonHoc.put(monHoc, diem);
    }

    // Tính điểm trung bình các môn
    public double tinhDiemTrungBinh() {
        if (diemMonHoc.isEmpty()) {
            return 0.0;
        }
        double tong = 0;
        for (double diem : diemMonHoc.values()) {
            tong += diem;
        }
        return tong / diemMonHoc.size();
    }

    public void hienThiThongTin() {
        System.out.printf("Mã SV: %-10s | Tên SV: %-20s | ĐTB: %-5.2f\n", maSV, tenSV, tinhDiemTrungBinh());
        System.out.println("  -> Bảng điểm: " + (diemMonHoc.isEmpty() ? "Chưa có điểm" : diemMonHoc));
    }
}