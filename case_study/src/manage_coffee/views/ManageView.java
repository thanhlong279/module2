package manage_coffee.views;

import manage_coffee.models.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ManageView {
    private static ManageView instance;

    private ManageView() {
    }

    ;

    public synchronized static ManageView getInstance() {
        if (instance == null) {
            instance = new ManageView();
        }
        return instance;
    }

    public int viewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Menu-------");
        System.out.println("1. thêm mới sản phẩm");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. tìm kiếm sản phẩm");
        System.out.println("4. xóa sản phẩm");
        System.out.println("5. sửa thông tin sản phẩm");
        System.out.println("6. In danh sách bán hàng");
        System.out.println("7. lấy tổng tiền bán hàng trong ngày");
        System.out.println("0. kết thúc trương trình");
        int choice = -1;
        do {
            try {
                System.out.println("Mời bạn chọn chức năng");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("nhập số nguyên từ 0-5 để trọn chức năng");
            }
        } while (choice < 0 || choice > 7);
        return choice;
    }

    public int viewCoffee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. HighlandsCoffee");
        System.out.println("2. Nescafe");
        System.out.println("3. TrungNguyenCoffee");
        System.out.println("0. Quay lại");
        int choice = -1;
        do {
            try {
                System.out.println("Mời bạn chọn chức năng:");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên từ 0 -> 3 để trọn chức năng");
            }
        } while (choice < 0 || choice > 3);
        return choice;
    }

    public Coffee addHighlandsCoffee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập code: ");
        String code = "HLC" + sc.nextLine();
        System.out.println("Nhập tên coffee: ");
        String name = sc.nextLine();
        LocalDate manufacturingDate = null;
        while (true) {
            try {
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                manufacturingDate = LocalDate.of(year, month, day);
                break;
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số nguyên dương cho date");
            } catch (DateTimeParseException e) {
                System.out.println("date ko hợp lệ");
            }
        }
        double price = 0;
        while (price <= 0 || price >= 100000000) {
            try {
                System.out.println("Giá bán: ");
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int expiry = 0;
        while (expiry <= 0 || expiry >= 100000000) {
            try {
                System.out.println("Hạn sử dụng(ngày): ");
                expiry = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        double discount = 0;
        while (discount <= 0 || discount >= 100) {
            try {
                System.out.println("Giảm giá(%): ");
                discount = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int duration = 0;
        while (duration <= 0 || duration >= expiry) {
            try {
                System.out.println("Thời gian giảm giá(ngày): ");
                duration = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int quantity = 0;
        while (quantity <= 0 || quantity >= 100000000) {
            try {
                System.out.println("số lượng(ly): ");
                quantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        return new HighlandsCoffee(code, name, expiry, duration, manufacturingDate, price, discount, quantity);
    }

    public Coffee addNetcafe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập code: ");
        String code = "NCC" + sc.nextLine();
        System.out.println("Nhập tên coffee: ");
        String name = sc.nextLine();
        LocalDate manufacturingDate = null;
        while (true) {
            try {
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                manufacturingDate = LocalDate.of(year, month, day);
                break;
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số nguyên dương cho date");
            } catch (DateTimeParseException e) {
                System.out.println("date ko hợp lệ");
            }
        }
        double price = 0;
        while (price <= 0 || price >= 100000000) {
            try {
                System.out.println("Giá bán: ");
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int expiry = 0;
        while (expiry <= 0 || expiry >= 100000000) {
            try {
                System.out.println("Hạn sử dụng(tháng): ");
                expiry = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        double discount = 0;
        while (discount <= 0 || discount >= 100) {
            try {
                System.out.println("Giảm giá(%): ");
                discount = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int duration = 0;
        while (duration <= 0 || duration >= expiry) {
            try {
                System.out.println("Thời gian giảm giá(tháng): ");
                duration = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int quantity = 0;
        while (quantity <= 0 || quantity >= 100000000) {
            try {
                System.out.println("số lượng(hộp): ");
                quantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        return new Nescafe(code, name, expiry, duration, manufacturingDate, price, discount, quantity);
    }

    public Coffee addTrungNguyenCoffee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập code: ");
        String code = "TNC" + sc.nextLine();
        System.out.println("Nhập tên coffee: ");
        String name = sc.nextLine();
        LocalDate manufacturingDate = null;
        while (true) {
            try {
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                manufacturingDate = LocalDate.of(year, month, day);
                break;
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số nguyên dương cho date");
            } catch (DateTimeParseException e) {
                System.out.println("date ko hợp lệ");
            }
        }
        double price = 0;
        while (price <= 0 || price >= 100000000) {
            try {
                System.out.println("Giá bán: ");
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int expiry = 0;
        while (expiry <= 0 || expiry >= 100000000) {
            try {
                System.out.println("Hạn sử dụng(tháng): ");
                expiry = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        double discount = 0;
        while (discount <= 0 || discount >= 100) {
            try {
                System.out.println("Giảm giá(%): ");
                discount = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        int duration = 0;
        while (duration <= 0 || duration >= expiry) {
            try {
                System.out.println("Thời gian giảm giá(tháng): ");
                duration = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        double weight = 0;
        while (weight <= 0 || weight >= 100000000) {
            try {
                System.out.println("số lượng: ");
                weight = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("mời bạn nhập số");
            }
        }
        return new TrungNguyenCoffee(code, name, expiry, duration, manufacturingDate, price, discount, weight);
    }

    public void viewMassage(boolean result) {
        if (result) {
            System.out.println("thao tác thành công");
        } else {
            System.out.println("thao tác thất bại");
        }
    }

    public void display(List<Coffee> coffeeList) {
        for (Coffee coffee : coffeeList) {
            coffee.printManage();
        }
    }

    public String inputSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên sản phẩm muốn tìm kiếm: ");
        return sc.nextLine();
    }

    public void viewMassageSearch() {
        System.out.println(" ko tìm thấy tên sản phẩm bạn muốn tìm kiếm");
    }

    public boolean confirm(Coffee product) {
        Scanner sc = new Scanner(System.in);
        System.out.println(product.toString());
        System.out.println("bạn có muốn xóa sản phẩm trên ko? bấm y để xác nhận");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean authUser(Auth auth) {
        Scanner sc = new Scanner(System.in);
        boolean authenticated = false;
        int logIn = 0;
        while (logIn < 5 && !authenticated) {
            System.out.println("đăng nhập tài khoản và mật khẩu");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (auth.authUser(username, password)) {
                authenticated = true;
                System.out.println("Đăng nhập thành công");
            } else {
                logIn++;
                System.out.println("tài khoản hoặc mật khẩu ko đúng " + (5 - logIn) + " lần thử");
            }
        }
        if (!authenticated) {
            System.out.println("Bạn đã sai quá nhiều lần, vui lòng thử lại sau.");
            return false;
        }
        return true;
    }

    public void messageAuthUser() {
        System.out.println("\"sai quá 5 lần, mời bạn thử lại sau: \"");
    }

    public void viewSaleDate(List<Bill> listBill) {
        for (Bill bill : listBill) {
            System.out.println("date: " + bill.getDate() + " time: " + bill.getTime() + " totalMoney: " + bill.getTotalMoney());
        }
    }

    public void getTotalSaleAmount(double totalSaleAmount) {
        System.out.println("tổng số tiền bán hàng trong ngày: " + totalSaleAmount);
    }

    public LocalDate inputDate() {
        Scanner sc = new Scanner(System.in);
        LocalDate date = null;
        while (true) {
            try {
                System.out.println("nhập ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("nhập tháng: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("nhập năm: ");
                int year = Integer.parseInt(sc.nextLine());
               return LocalDate.of(year, month, day);
            } catch (NumberFormatException e) {
                System.out.println("nhập vào số nguyên cho date");
            }catch (DateTimeParseException e){
                System.out.println("sai định dạng ngày");
            }
        }
    }
}

