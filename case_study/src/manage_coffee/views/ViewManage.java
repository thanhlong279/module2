package manage_coffee.views;

import manage_coffee.models.Coffee;
import manage_coffee.models.HighlandsCoffee;
import manage_coffee.models.Nescafe;
import manage_coffee.models.TrungNguyenCoffee;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ViewManage {
    private static ViewManage instance;

    private ViewManage() {
    }

    ;

    public synchronized static ViewManage getInstance() {
        if (instance == null) {
            instance = new ViewManage();
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
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập code: ");
                String code = "HLC" + sc.nextLine();
                System.out.println("Nhập tên coffee: ");
                String name = sc.nextLine();
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.println("Giá bán: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.println("Hạn sử dụng: ");
                int expiry = Integer.parseInt(sc.nextLine());
                System.out.println("Giảm giá: ");
                double discount = Double.parseDouble(sc.nextLine());
                System.out.println("Thời gian giảm giá: ");
                int duration = Integer.parseInt(sc.nextLine());
                System.out.println("số lượng: ");
                int quantity = Integer.parseInt(sc.nextLine());
                return new HighlandsCoffee(code, name, expiry, duration, manufacturingDate, price, discount, quantity);
            } catch (NumberFormatException e) {
                System.out.println(" nhập giá trị dương cho các giá trị");
            } catch (DateTimeParseException e) {
                System.out.println("ngày ko hợp lệ, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Coffee addNetcafe() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập code: ");
                String code = "NCC" + sc.nextLine();
                System.out.println("Nhập tên coffee: ");
                String name = sc.nextLine();
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.println("Giá bán: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.println("Hạn sử dụng: ");
                int expiry = Integer.parseInt(sc.nextLine());
                System.out.println("Giảm giá: ");
                double discount = Double.parseDouble(sc.nextLine());
                System.out.println("Thời gian giảm giá: ");
                int duration = Integer.parseInt(sc.nextLine());
                System.out.println("số lượng: ");
                int quantity = Integer.parseInt(sc.nextLine());
                return new Nescafe(code, name, expiry, duration, manufacturingDate, price, discount, quantity);
            } catch (NumberFormatException e) {
                System.out.println(" nhập giá trị dương cho các giá trị");
            } catch (DateTimeParseException e) {
                System.out.println("ngày ko hợp lệ, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Coffee addTrungNguyenCoffee() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập code: ");
                String code = "TNC" + sc.nextLine();
                System.out.println("Nhập tên coffee: ");
                String name = sc.nextLine();
                System.out.println("Ngày: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.println("Giá bán: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.println("Hạn sử dụng: ");
                int expiry = Integer.parseInt(sc.nextLine());
                System.out.println("Giảm giá: ");
                double discount = Double.parseDouble(sc.nextLine());
                System.out.println("Thời gian giảm giá: ");
                int duration = Integer.parseInt(sc.nextLine());
                System.out.println("Khối lượng: ");
                double weight = Double.parseDouble(sc.nextLine());
                return new TrungNguyenCoffee(code, name, expiry, duration, manufacturingDate, price, discount, weight);
            } catch (NumberFormatException e) {
                System.out.println(" nhập giá trị dương cho các giá trị");
            } catch (DateTimeParseException e) {
                System.out.println("ngày ko hợp lệ, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
            System.out.println(coffee.toString());
        }
    }
}

