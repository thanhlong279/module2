package manage_coffee.views;

import manage_coffee.models.*;

import java.util.*;

public class ShopView {
    private static ShopView instance;

    private ShopView() {
    }

    ;


    public synchronized static ShopView getInstance() {
        if (instance == null) {
            instance = new ShopView();
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
            System.out.println("code: "+coffee.getCode()+" ,name: "+coffee.getName()+" ,giá bán: "+coffee.getPrice());
        }
    }

    public int viewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Menu-------");
        System.out.println("1. thêm sản phẩm vào giỏ hàng");
        System.out.println("2. xóa sản phẩm khỏi giỏ hàng");
        System.out.println("3. hiển thị danh sách giỏ hàng");
        System.out.println("4. thanh toán giỏ hàng");
        System.out.println("0. kết thúc trương trình");
        int choice = -1;
        do {
            try {
                System.out.println("Mời bạn chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("nhập số nguyên từ 0-2 để trọn chức năng");
            }
        } while (choice < 0 || choice > 4);
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

    public void viewMasageCart(boolean result) {
        if (result) {
            System.out.println("thao tác thành công");
        } else {
            System.out.println("sản phẩm bạn trọn ko có trong cửa hàng");
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

    public List<CustomerCart> getAmount(List<Coffee> coffees) {
        Scanner sc = new Scanner(System.in);
        String code;
        String name;
        double quantity = 0;
        List<CustomerCart> list = new ArrayList<>();
        for (Coffee coffee : coffees) {
            code = coffee.getCode();
            name = coffee.getName();
            System.out.println(coffee.toString());
            System.out.println("Nhập số lượng bạn mua: ");
            quantity = Double.parseDouble(sc.nextLine());
            CustomerCart customerCart = new CustomerCart(code, name, quantity);
            list.add(customerCart);
        }
        return list;
    }

    public void viewMasageValidateCart() {
        System.out.println("cửa hàng ko đủ số lượng bạn muốn mua, mời bạn nhập lại");
    }

    public boolean confirmGetAmount(List<CustomerCart> cartList) {
        for (CustomerCart customerCart : cartList) {
            System.out.println(customerCart.toString());
        }
        System.out.println("bạn có muốn mua thanh toán sản phẩm trong giỏ hàng? bấm 'y' để thanh toán");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public void getTotalMoney(List<CustomerCart> list, double totalMoney) {
        for (CustomerCart customerCart : list) {
            System.out.println(customerCart.toString());
        }
        System.out.println("tổng số tiền cho đơn hàng trên: " + totalMoney + " VNĐ");
    }
}
