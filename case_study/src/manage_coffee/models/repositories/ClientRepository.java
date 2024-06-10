package manage_coffee.models.repositories;

import manage_coffee.models.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements Serializable {
    private static String FILE_CART = "D:\\code_gym\\module_2_java\\session\\module2\\case_study\\src\\cart_client.csv";
    private static String FILE_COFFEE = "D:\\code_gym\\module_2_java\\session\\module2\\case_study\\src\\manage_coffee.csv";
    private static String FILE_SALES = "D:\\code_gym\\module_2_java\\session\\module2\\case_study\\src\\sale_data_txt";
    private static ClientRepository instance;

    private ClientRepository() {
    }

    ;

    public synchronized static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    public void addCart(Coffee coffee) {
        List<Coffee> coffeeList = readFile(FILE_CART);
        coffeeList.add(coffee);
        writeFile(coffeeList, false, FILE_CART);
    }

    public void writeFile(List<Coffee> coffeeList, boolean apprnd, String nameFile) {
        File file = new File(nameFile);
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
                if (line.startsWith("HLC")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    coffeeList.add(new HighlandsCoffee(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                            LocalDate.of(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])),
                            Double.parseDouble(temp[7]), Double.parseDouble(temp[8]), Integer.parseInt(temp[9])));
                }
                if (line.startsWith("NCC")) {
                    String[] temp = line.replaceAll("-", ",").split(",");
                    coffeeList.add(new Nescafe(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                            LocalDate.of(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])),
                            Double.parseDouble(temp[7]), Double.parseDouble(temp[8]), Integer.parseInt(temp[9])));
                }
                if (line.startsWith("TNC")) {
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

    public List<Coffee> getAllCart() {
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
        writeFile(result, true, FILE_CART);
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
        writeFile(coffees, false, FILE_CART);
    }

    public double getTotalMoney(List<CustomerCart> cartList) {
        double totalHighlandsCoffee = 0;
        double totalTrungNguyenCoffee = 0;
        double totalNescafe = 0;
        List<Coffee> listCart = readFile(FILE_CART);
        for (CustomerCart customerCart : cartList) {
            for (Coffee coffee : listCart) {
                if (coffee instanceof HighlandsCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    totalHighlandsCoffee += coffee.getReadMoney() * customerCart.getQuantity();
                }
                if (coffee instanceof Nescafe && coffee.getCode().equals(customerCart.getCode())) {
                    totalNescafe += coffee.getReadMoney() * customerCart.getQuantity();
                }
                if (coffee instanceof TrungNguyenCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    totalTrungNguyenCoffee += coffee.getReadMoney() * customerCart.getQuantity();
                }
            }
        }
        return totalNescafe + totalHighlandsCoffee + totalTrungNguyenCoffee;
    }

    public void updateFileProduct(List<CustomerCart> cartList) {
        List<Coffee> coffees = readFile(FILE_COFFEE);
        List<Coffee> toRemove = new ArrayList<>();
        for (Coffee coffee : coffees) {
            for (CustomerCart customerCart : cartList) {
                if (coffee instanceof HighlandsCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    ((HighlandsCoffee) coffee).setQuantity((int) (((HighlandsCoffee) coffee).getQuantity() - customerCart.getQuantity()));
                    if (((HighlandsCoffee) coffee).getQuantity() == 0) {
                        toRemove.add(coffee);
                    }
                }
                if (coffee instanceof Nescafe && coffee.getCode().equals(customerCart.getCode())) {
                    ((Nescafe) coffee).setQuantity((int) (((Nescafe) coffee).getQuantity() - customerCart.getQuantity()));
                    if (((Nescafe) coffee).getQuantity() == 0) {
                        toRemove.add(coffee);
                    }
                }
                if (coffee instanceof TrungNguyenCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    ((TrungNguyenCoffee) coffee).setWeight(((TrungNguyenCoffee) coffee).getWeight() - customerCart.getQuantity());
                    if (((TrungNguyenCoffee) coffee).getWeight() == 0) {
                        toRemove.add(coffee);
                    }
                }
            }
        }
        coffees.removeAll(toRemove);
        writeFile(coffees, false, FILE_COFFEE);
    }

    public void updateFileCart() {
        List<Coffee> newCartList = new ArrayList<>();
        writeFile(newCartList, false, FILE_CART);
    }

    public void updateSaleData(List<CustomerCart> cartList) {
        double totalMoney = getTotalMoney(cartList);
        String saleInfo = LocalDate.now()+","+LocalTime.now().withNano(0)+","+totalMoney;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_SALES, true))) {
            writer.write(saleInfo);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
