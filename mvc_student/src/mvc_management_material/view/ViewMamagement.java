package mvc_management_material.view;

import mvc_management_material.models.CrispyFlour;
import mvc_management_material.models.Material;
import mvc_management_material.models.Meat;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ViewMamagement {
    public int view() {
        System.out.println("-----Menu-----");
        System.out.println("1. add Material");
        System.out.println("2. edit Material");
        System.out.println("3. delete Material");
        System.out.println("4. display");
        System.out.println("5. Material search by name");
        System.out.println("6. tính tổng tiền của vật liệu");
        System.out.println("7. Tính chênh lệch giữa triết khấu và ko triết khấu");
        System.out.println("8. sắp xếp vật liệu theo giá");
        System.out.println("9. lưu file");
        System.out.println("0. Edit");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.println(" input your choice:");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("nhập 1 số nguyên dương từ 0 ->8");
            }
        } while (choice < 0 || choice > 8);
        return choice;
    }

    public int viewMaterial() {
        System.out.println(" input your choice Material: ");
        System.out.println("1. Crispy Flour");
        System.out.println("2. Meat");
        System.out.println("0. Edit");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.println(" input your choice Material:");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" mời bạn nhập 1 số nguyên dương từ 0->2");
            }
        } while (choice < 0 || choice > 2);

        return choice;
    }

    public Material addCrispyFlour() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("id: ");
                String id = "CF" + sc.nextLine();
                System.out.println("name: ");
                String name = sc.nextLine();
                System.out.println("ManufacturingDate(day): ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("ManufacturingDate(month): ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("ManufacturingDate(year): ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.println("Cost: ");
                int cost = Integer.parseInt(sc.nextLine());
                System.out.println("Quantity: ");
                double quantity = Double.parseDouble(sc.nextLine());
                return new CrispyFlour(id, name, manufacturingDate, cost, quantity);
            } catch (NumberFormatException e) {
                System.err.println("Nhập các giá trị số dương cho ngày, tháng, năm, cost và quantity");
            } catch (DateTimeParseException e) {
                System.err.println("Ngày không hợp lệ. Vui lòng nhập một ngày hợp lệ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Material addMeat() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("id: ");
                String id = "M" + sc.nextLine();
                System.out.println("name: ");
                String name = sc.nextLine();
                System.out.println("ManufacturingDate(day): ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("ManufacturingDate(month): ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("ManufacturingDate(year): ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.println("Cost: ");
                int cost = Integer.parseInt(sc.nextLine());
                System.out.println("Weight");
                double weight = Double.parseDouble(sc.nextLine());
                return new Meat(id, name, manufacturingDate, cost, weight);
            } catch (NumberFormatException e) {
                System.err.println("Nhập các giá trị số dương cho ngày, tháng, năm, cost và quantity");
            } catch (DateTimeParseException e) {
                System.err.println("Ngày không hợp lệ. Vui lòng nhập một ngày hợp lệ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void viewMasage(boolean result) {
        if (result) {
            System.out.println("thành công");
        } else {
            System.out.println("thất bại");
        }
    }

    public void displayMaterial(List<Material> materials) {
        for (Material material : materials) {
            System.out.println(material.toString());
        }
    }

    public String inputStr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input string: ");
        String id = sc.nextLine();
        return id;
    }

    public boolean confirmDeleteEdit(Material material) {
        System.out.println("bạn có muốn xóa(sửa) vật liệu " + material.getId() + " Bấm y để xóa(sửa), n để hủy bỏ");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}
