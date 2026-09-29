import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bai5 {
    // TreeMap giúp tự động sắp xếp các từ tiếng Anh theo thứ tự Alphabet
    private static Map<String, String> dictionary = new TreeMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========== TỪ ĐIỂN ANH - VIỆT ==========");
            System.out.println("1. Thêm / Cập nhật từ vựng");
            System.out.println("2. Tra từ điển");
            System.out.println("3. Hiển thị toàn bộ từ điển (sắp xếp Alphabet)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themHoacCapNhatTu();
                    break;
                case 2:
                    traTu();
                    break;
                case 3:
                    hienThiTuDien();
                    break;
                case 0:
                    System.out.println("Đã thoát từ điển!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void themHoacCapNhatTu() {
        System.out.print("\nNhập từ tiếng Anh: ");
        String english = scanner.nextLine().trim().toLowerCase();

        System.out.print("Nhập nghĩa tiếng Việt: ");
        String vietnamese = scanner.nextLine().trim();

        if (dictionary.containsKey(english)) {
            System.out.println("-> Từ '" + english + "' đã tồn tại. Nghĩa cũ sẽ được cập nhật lại!");
        } else {
            System.out.println("-> Thêm từ mới thành công!");
        }

        dictionary.put(english, vietnamese);
    }

    private static void traTu() {
        System.out.print("\nNhập từ tiếng Anh cần tra: ");
        String english = scanner.nextLine().trim().toLowerCase();

        if (dictionary.containsKey(english)) {
            System.out.println("=> Nghĩa của '" + english + "': " + dictionary.get(english));
        } else {
            System.out.println("=> Không tìm thấy từ '" + english + "' trong từ điển!");
        }
    }

    private static void hienThiTuDien() {
        if (dictionary.isEmpty()) {
            System.out.println("\nTừ điển hiện đang trống!");
            return;
        }

        System.out.println("\n================ DANH SÁCH TỪ VỰNG ================");
        System.out.printf("| %-20s | %-30s |\n", "Tiếng Anh", "Tiếng Việt");
        System.out.println("---------------------------------------------------");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.printf("| %-20s | %-30s |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------------------");
    }
}