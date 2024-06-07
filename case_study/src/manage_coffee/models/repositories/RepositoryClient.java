package manage_coffee.models.repositories;

import manage_coffee.models.Coffee;
import manage_coffee.models.HighlandsCoffee;
import manage_coffee.models.Nescafe;
import manage_coffee.models.TrungNguyenCoffee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryClient implements Serializable {
    //    private static List<Coffee> listCart = new ArrayList<>();
    private static String FILE_CART = "D:\\code_gym\\module_2_java\\session\\case_study\\src\\cart_client.csv";
    private static String FILE_COFFEE = "D:\\code_gym\\module_2_java\\session\\case_study\\src\\manage_coffee.csv";
    private static RepositoryClient instance;

    private RepositoryClient() {
    }

    ;

    public synchronized static RepositoryClient getInstance() {
        if (instance == null) {
            instance = new RepositoryClient();
        }
        return instance;
    }

    public void addCart(Coffee coffee) {
        List<Coffee> coffeeList = readFile(FILE_CART);
        coffeeList.add(coffee);
        writeFile(coffeeList, false);
    }

    public void writeFile(List<Coffee> coffeeList, boolean apprnd) {
        File file = new File(FILE_CART);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, apprnd);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Coffee coffee : coffeeList) {
                bufferedWriter.write(toString(coffee));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("lỗi đóng file");
                }
            }
        }
    }

    public List<Coffee> readFile(String fileName) {
        List<Coffee> coffeeList = new ArrayList<>();
        File file = new File(fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("HLC")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    coffeeList.add(new HighlandsCoffee(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                            LocalDate.of(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])),
                            Double.parseDouble(temp[7]), Double.parseDouble(temp[8]), Integer.parseInt(temp[9])));
                }
                if (line.contains("NCC")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    coffeeList.add(new Nescafe(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                            LocalDate.of(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])),
                            Double.parseDouble(temp[7]), Double.parseDouble(temp[8]), Integer.parseInt(temp[9])));
                }
                if (line.contains("TNC")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    coffeeList.add(new TrungNguyenCoffee(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                            LocalDate.of(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])),
                            Double.parseDouble(temp[7]), Double.parseDouble(temp[8]), Double.parseDouble(temp[9])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(" ko tìm thấy file");
        } catch (IOException e) {
            System.out.println(" lỗi đọc dữ liệu");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("lỗi đóng file");
                }
            }
        }
        return coffeeList;
    }

    private String toString(Coffee coffee) {
        if (coffee instanceof HighlandsCoffee) {
            return coffee.getCode() + "," + coffee.getName() + "," + coffee.getExpiry() + "," + coffee.getDuration() + "," +
                    coffee.getManufacturingDate() + "," + coffee.getPrice() + "," + coffee.getDiscount() + "," +
                    ((HighlandsCoffee) coffee).getQuantity();
        }
        if (coffee instanceof Nescafe) {
            return coffee.getCode() + "," + coffee.getName() + "," + coffee.getExpiry() + "," + coffee.getDuration() + "," +
                    coffee.getManufacturingDate() + "," + coffee.getPrice() + "," + coffee.getDiscount() + "," +
                    ((Nescafe) coffee).getQuantity();
        }
        if (coffee instanceof TrungNguyenCoffee) {
            return coffee.getCode() + "," + coffee.getName() + "," + coffee.getExpiry() + "," + coffee.getDuration() + "," +
                    coffee.getManufacturingDate() + "," + coffee.getPrice() + "," + coffee.getDiscount() + "," +
                    ((TrungNguyenCoffee) coffee).getWeight();
        }
        return null;
    }

    public List<Coffee> getAll() {
        return new ArrayList<>(readFile(FILE_CART));
    }

    public List<Coffee> getAllProduct() {
        return new ArrayList<>(readFile(FILE_COFFEE));
    }

    public List<Coffee> addCart(List<String> list) {
        List<Coffee> coffees = readFile(FILE_COFFEE);
        List<Coffee> result = new ArrayList<>();
        int coffeesSize = coffees.size();
        int listString = list.size();
        for (int i = 0; i < coffeesSize; i++) {
            for (int j = 0; j < listString; j++) {
                if (coffees.get(i).getCode().equalsIgnoreCase(list.get(j))) {
                    result.add(coffees.get(i));
                }
            }
        }
        writeFile(result, true);
        return result;

    }

    public void deleteProductInCart(List<String> list) {
        List<Coffee> coffees = readFile(FILE_CART);
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffees) {
            for (String string : list) {
                if (coffee.getCode().equalsIgnoreCase(string)) {
                    result.add(coffee);
                    break;
                }
            }
        }
        coffees.removeAll(result);
        writeFile(coffees, false);
    }
}
