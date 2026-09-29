package bai10;

public class OrderItem {
    private Product product;
    private int soLuong;

    public OrderItem(Product product, int soLuong) {
        this.product = product;
        this.soLuong = soLuong;
    }

    public Product getProduct() {
        return product;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Tính thành tiền từng món
    public double getThanhTien() {
        return product.getGia() * soLuong;
    }
}