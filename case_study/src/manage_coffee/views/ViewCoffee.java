package manage_coffee.views;

import java.util.Scanner;

public class ViewCoffee {
    public int viewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Menu-------");
        System.out.println("1. thêm mới sản phẩm");
        System.out.println("2. Hiển thị toàn danh sách sản phẩm");
        System.out.println("3. tìm kiếm sản phẩm");
        System.out.println("4. xóa sản phẩm");
        System.out.println("5. sửa thông tin sản phẩm");
        System.out.println("0. kết thúc trương trình");
        int choice = -1;
        do {
            try {
                System.out.println("Mời bạn chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("nhập số nguyên từ 0-5 để trọn chức năng");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }
}
