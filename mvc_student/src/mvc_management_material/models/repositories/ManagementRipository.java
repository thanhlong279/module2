package mvc_management_material.models.repositories;

import mvc_management_material.models.CrispyFlour;
import mvc_management_material.models.Material;
import mvc_management_material.models.Meat;
import java.time.LocalDate;
import java.util.*;

public class ManagementRipository {
    private static List<Material> materials = new ArrayList<>();

    static {
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
        materials.add(new CrispyFlour("1", "Bột mì1", date1, 5, 8));
        materials.add(new CrispyFlour("2", "Bột mì2", date2, 4, 9));
        materials.add(new CrispyFlour("3", "Bột mì3", date3, 3, 7));
        materials.add(new CrispyFlour("4", "Bột mì4", date4, 6, 10));
        materials.add(new CrispyFlour("5", "Bột mì5", date5, 7, 11));
        materials.add(new Meat("6", "Thịt 1", date6, 8, 1));
        materials.add(new Meat("7", "Thịt 2", date7, 7, 5));
        materials.add(new Meat("8", "Thịt 3", date8, 5, 4));
        materials.add(new Meat("9", "Thịt 4", date9, 6, 2));
        materials.add(new Meat("10", "Thịt 5", date10, 9, 3));

    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public List<Material> copyList() {
        List<Material> newList = new ArrayList<>();
        newList.addAll(materials);
        return newList;
    }

    public Material findByID(String id) {
        for (Material material : materials) {
            if (material == null) {
                return null;
            }
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }

    public void removeMaterial(Material material) {
        int size = materials.size();
        for (int i = 0; i < size; i++) {
            if (materials.get(i).getId().equals(material.getId())) {
                materials.remove(i);
                break;
            }
        }
    }

    public void editMaterial(Material material) {
        int size = materials.size();
        for (int i = 0; i < size; i++) {
            if (materials.get(i).getId().equals(material.getId())) {
                materials.set(i, material);
                break;
            }
        }
    }

    public void totalNotMoneyDiscount() {
        double totalNotMoneyDiscount = 0;
        double totalMoneyDiscount = 0;
        for (Material material : materials) {
            totalNotMoneyDiscount += material.getAmount();
            totalMoneyDiscount += material.getRealMoney(LocalDate.now());
        }
        System.out.println("chênh lệch triết khấu ngày hôm nay: "+(totalNotMoneyDiscount - totalMoneyDiscount));
    }

    public void totalMoneyDiscount() {
        double total = 0;
        for (Material material : materials) {
            total += material.getRealMoney(LocalDate.now());
        }
        System.out.println("Tổng số tiền sau giảm giá: " + total);
    }

//    public void sortMaterialByPrince(){
//        Collections.sort(materials, new Comparator<Material>() {
//
//            @Override
//            public int compare(Material o1, Material o2) {
//                return (int) (o1.getRealMoney(LocalDate.now()) - o2.getRealMoney(LocalDate.now()));
//            }
//        });
//    }
}
