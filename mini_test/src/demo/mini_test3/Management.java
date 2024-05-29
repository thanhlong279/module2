package demo.mini_test3;

import java.time.LocalDate;
import java.util.*;

public class Management {
    static List<Material> list = new ArrayList<>();

    public void addMaterial(Material material) {
        list.add(material);
    }

    public void deleteMaterial(int index) {
        if (index < list.size() && index >= 0) {
            list.remove(index);
        }
    }

    public void editMaterial(int index, Material material) {
        if (index < list.size() && index >= 0) {
            list.set(index, material);
        }
    }

    public void printMaterial() {
        for (Material lists : list) {
            System.out.println(lists.toString());
        }
    }

    public double totalNotMoneyDiscount(){
        double total = 0;
        for(Material l : list){
            total += l.getAmount();
        }
        return total;
    }
    public double totalMoneyDiscount() {
        double total = 0;
        for (Material l : list) {
            total += l.getRealMoney(LocalDate.now());
        }
        return total;
    }

    public List<Material> getAll() {
        List<Material> result = new ArrayList<>();
        Collections.copy(list, result);
        return result;
    }

    public List<Material> sortMaterialByPrince() {
        List<Material> result = this.getAll();
        Collections.sort(list, new Comparator<Material>() {
            @Override
            public int compare(Material o1, Material o2) {
                return (int) (o1.getRealMoney(LocalDate.now()) - o2.getRealMoney(LocalDate.now()));
            }
        });
        return result;
    }
}
