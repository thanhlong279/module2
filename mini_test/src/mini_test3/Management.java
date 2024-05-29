package mini_test3;

import java.time.LocalDate;
import java.util.*;

public class Management {
    static List<Material> list = new ArrayList<>();

    public void addMaterial(Material material) {
        list.add(material);
    }

    public void deleteMaterial(String id) {
        for (Material material : list) {
            if (material.getId().equals(id)) {
                list.remove(material);
                break;
            }
        }
    }

    public void editMaterial(String id, Material material) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, material);
            }
        }
    }

    public void printMaterial() {
        for (Material lists : list) {
            System.out.println(lists.toString());
        }
    }

    public void totalNotMoneyDiscount() {
        double totalNotMoneyDiscount = 0;
        double totalMoneyDiscount = 0;
        for (Material materials : list) {
            totalNotMoneyDiscount += materials.getAmount();
            totalMoneyDiscount += materials.getRealMoney(LocalDate.now());
        }
        System.out.println("chênh lệch triết khấu ngày hôm nay: "+(totalNotMoneyDiscount - totalMoneyDiscount));
    }

    public void totalMoneyDiscount() {
        double total = 0;
        for (Material material : list) {
            total += material.getRealMoney(LocalDate.now());
        }
        System.out.println("Tổng số tiền sau giảm giá: " + total);
    }

    public void sortMaterialByPrince() {
        Collections.sort(list, new Comparator<Material>() {
            @Override
            public int compare(Material o1, Material o2) {
                return (int) (o1.getRealMoney(LocalDate.now()) - o2.getRealMoney(LocalDate.now()));
            }
        });
    }
}
