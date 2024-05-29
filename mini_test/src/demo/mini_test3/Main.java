package demo.mini_test3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 12, 5);
        LocalDate date2 = LocalDate.of(2024, 2, 5);
        LocalDate date3 = LocalDate.of(2024, 3, 5);
        LocalDate date4 = LocalDate.of(2024, 1, 5);
        LocalDate date5 = LocalDate.of(2023, 11, 5);
        LocalDate date6 = LocalDate.of(2024, 5, 5);
        LocalDate date7 = LocalDate.of(2024, 5, 5);
        LocalDate date8 = LocalDate.of(2024, 5, 5);
        LocalDate date9 = LocalDate.of(2024, 5, 5);
        LocalDate date10 = LocalDate.of(2024, 5, 5);

        Material cf1 = new CrispyFlour("1", "Bột mì1", date1, 5, 8);
        Material cf2 = new CrispyFlour("2", "Bột mì2", date2, 4, 9);
        Material cf3 = new CrispyFlour("3", "Bột mì3", date3, 3, 7);
        Material cf4 = new CrispyFlour("4", "Bột mì4", date4, 6, 10);
        Material cf5 = new CrispyFlour("5", "Bột mì5", date5, 7, 11);
        Material m1 = new Meat("6", "Thịt 1", date6, 8, 1);
        Material m2 = new Meat("7", "Thịt 2", date7, 7, 5);
        Material m3 = new Meat("8", "Thịt 3", date8, 5, 4);
        Material m4 = new Meat("9", "Thịt 4", date9, 6, 2);
        Material m5 = new Meat("10", "Thịt 5", date10, 9, 3);
        Management management = new Management();

        management.addMaterial(cf1);
        management.addMaterial(cf2);
        management.addMaterial(cf3);
        management.addMaterial(cf4);
        management.addMaterial(cf5);
        management.addMaterial(m1);
        management.addMaterial(m2);
        management.addMaterial(m3);
        management.addMaterial(m4);
        management.addMaterial(m5);

        management.deleteMaterial(4);
        management.editMaterial(2, new Meat("6", "Thịt 1", date6, 8, 1));


        System.out.println(" sản phẩm trước sắp xếp: ");
        management.printMaterial();
        System.out.println(" sản phẩm sau sắp xếp");
        management.sortMaterialByPrince();
        management.printMaterial();

        double totalMoneyDiscount = management.totalMoneyDiscount();
        double totalNotMoneyDiscount = management.totalNotMoneyDiscount();
        System.out.println(" tổng số tiền sau khi giảm giá: " +totalMoneyDiscount);
        System.out.println("số chênh lệch triết khấu này hôm nay: " + (totalNotMoneyDiscount-totalMoneyDiscount));
    }



}
