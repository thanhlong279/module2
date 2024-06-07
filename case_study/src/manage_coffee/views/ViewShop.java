package manage_coffee.views;

import manage_coffee.models.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewShop {
    private static ViewShop instance;

    private ViewShop() {
    }

    ;


    public synchronized static ViewShop getInstance() {
        if (instance == null) {
            instance = new ViewShop();
        }
        return instance;
    }

    public void viewProduct(List<Coffee> coffees) {
        for (Coffee coffee : coffees) {
            System.out.println(coffee.toString());
        }
    }

    public void viewCart(List<Coffee> coffees) {
        System.out.println("danh sách sản phẩm trong giỏ hàng: ");
        for (Coffee coffee : coffees) {
            System.out.println(coffee.toString());
        }
    }

    public int viewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Menu-------");
        System.out.println("1. thêm sản phẩm vào giỏ hàng");
        System.out.println("2. xóa sản phẩm khỏi giỏ hàng");
        System.out.println("3. hiển thị danh sách giỏ hàng");
        System.out.println("0. kết thúc trương trình");
        int choice = -1;
        do {
            try {
                System.out.println("Mời bạn chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("nhập số nguyên từ 0-2 để trọn chức năng");
            }
        } while (choice < 0 || choice > 3);
        return choice;
    }

    public List<String> addCart() {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String input;
        do {
            System.out.println("thêm sản phẩm vào giỏ hàng, bấm 'E' để dừng lại");
            input = sc.nextLine();
            if (!input.equalsIgnoreCase("E")) {
                list.add(input);
            }
        } while (!input.equalsIgnoreCase("E"));
        return list;
    }

    public List<String> deleteCart() {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String input;
        do {
            System.out.println("xóa sản phẩm trong giỏ hàng, bấm 'E' để dừng lại");
            input = sc.nextLine();
            if (!input.equalsIgnoreCase("E")) {
                list.add(input);
            }
        } while (!input.equalsIgnoreCase("E"));
        return list;
    }

//    public String inputIDProduct() {
//        Scanner sc = new Scanner(System.in);
//        String input;
//            System.out.println("thêm sản phẩm vào giỏ hàng, bấm 'E' để dừng lại");
//            input = sc.nextLine();
//        return input;
//    }

    public void viewMasageCart(boolean result) {
        if (result) {
            System.out.println("thao tác thành công");
        } else {
            System.out.println("sản phẩm ko có trong cửa hàng");
        }
    }

    public boolean confirmDeleteInCart(List<Coffee> coffees) {
        System.out.println("bạn có muốn xóa: ");
        for (Coffee coffee : coffees) {
            System.out.println(coffee.toString());
        }
        System.out.println(" bấm 'y' để xác nhận, 'n' để hủy bỏ");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
}
