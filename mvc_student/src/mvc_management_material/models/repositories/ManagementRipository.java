package mvc_management_material.models.repositories;

import mvc_management_material.models.CrispyFlour;
import mvc_management_material.models.Material;
import mvc_management_material.models.Meat;
import mvc_person.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ManagementRipository {
    private static List<Material> materials = new ArrayList<>();
    private String FILE_MATERIALS = "D:\\code_gym\\module_2_java\\session\\mvc_student\\src\\mvc_material.csv";

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
        materials.add(new CrispyFlour("CF1", "Bột mì1", date1, 5, 8));
        materials.add(new CrispyFlour("CF2", "Bột mì2", date2, 4, 9));
        materials.add(new CrispyFlour("CF3", "Bột mì3", date3, 3, 7));
        materials.add(new CrispyFlour("CF4", "Bột mì4", date4, 6, 10));
        materials.add(new CrispyFlour("CF5", "Bột mì5", date5, 7, 11));
        materials.add(new Meat("M1", "Thịt 1", date6, 8, 1));
        materials.add(new Meat("M3", "Thịt 2", date7, 7, 5));
        materials.add(new Meat("M3", "Thịt 3", date8, 5, 4));
        materials.add(new Meat("M4", "Thịt 4", date9, 6, 2));
        materials.add(new Meat("M5", "Thịt 5", date10, 9, 3));

    }

    public void addMaterial(Material material) {
        List<Material> materials = copyList();
        materials.add(material);
        writeFile(materials, true);
    }

//    public List<Material> copyList() {
//        List<Material> newList = new ArrayList<>();
//        newList.addAll(materials);
//        return newList;
//    }

    public List<Material> copyList() {
        List<Material> materials1 = new ArrayList<>();
        File file = new File(FILE_MATERIALS);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("M")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    materials1.add(new Meat(temp[0], temp[1], LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4])), Integer.parseInt(temp[5]), Double.parseDouble(temp[6])));
                }
                if (line.contains("CF")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    materials1.add(new CrispyFlour(temp[0], temp[1], LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4])), Integer.parseInt(temp[5]), Double.parseDouble(temp[6])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khômng tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu");
        } finally {
            if( br !=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
        return materials1;
    }

    public Material findByID(String id) {
        List<Material> materials = copyList();
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
        List<Material> materials = copyList();
        int size = materials.size();
        for (int i = 0; i < size; i++) {
            if (materials.get(i).getId().equals(material.getId())) {
                materials.remove(i);
                writeFile(materials, false);
                break;
            }
        }
    }

    public void editMaterial(Material material) {
        List<Material> materials = copyList();
        int size = materials.size();
        for (int i = 0; i < size; i++) {
            if (materials.get(i).getId().equals(material.getId())) {
                materials.set(i, material);
                writeFile(materials, false);
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
        System.out.println("chênh lệch triết khấu ngày hôm nay: " + (totalNotMoneyDiscount - totalMoneyDiscount));
    }

    public void totalMoneyDiscount() {
        double total = 0;
        for (Material material : materials) {
            total += material.getRealMoney(LocalDate.now());
        }
        System.out.println("Tổng số tiền sau giảm giá: " + total);
    }

    public void writeFile(List<Material> materials, boolean append) {
        File file = new File(FILE_MATERIALS);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Material temp: materials) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            if(bufferedWriter !=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
    }

    public String toString(Material material) {
        if (material instanceof CrispyFlour) {
            return material.getId() + "," + material.getName() + "," + material.getManufacturingDate() + "," + material.getCost() + "," + ((CrispyFlour) material).getQuantity();
        }
        if (material instanceof Meat) {
            return material.getId() + "," + material.getName() + "," + material.getManufacturingDate() + "," + material.getCost() + "," + ((Meat) material).getWeight();
        } else
            return null;
    }
}
