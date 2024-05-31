package ex1_manager_product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ViewProduct vp = new ViewProduct();
        Manager manager = new Manager();
        Product product;
        boolean result;
        String searchId;
        while (true) {
            int choice = vp.view();
            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            product = vp.viewAdd();
                            result = manager.addProduct(product);
                            vp.viewMessage(result);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    List<Product> products = manager.getAll();
                    vp.display(products);
                    break;
                case 3:
                    searchId = vp.inputID();
                    product = manager.findById(searchId);
                    if (product == null) {
                        System.out.println(" ko tìm thấy sản phẩm");
                    }else{
                        vp.displayProduct(product);
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
