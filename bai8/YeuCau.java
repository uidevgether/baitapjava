package bai8;

public class YeuCau {
    private String id;
    private String moTa;
    private int doUuTien; // Số càng lớn thì độ ưu tiên càng cao (ví dụ: 10 > 1)

    public YeuCau(String id, String moTa, int doUuTien) {
        this.id = id;
        this.moTa = moTa;
        this.doUuTien = doUuTien;
    }

    public String getId() {
        return id;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getDoUuTien() {
        return doUuTien;
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Mô tả: %-25s | Độ ưu tiên: %d", id, moTa, doUuTien);
    }
}
