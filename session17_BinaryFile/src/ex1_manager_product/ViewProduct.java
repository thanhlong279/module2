package ex1_manager_product;

import pr1_binary_file.Student;

import java.util.List;
import java.util.Scanner;

public class ViewProduct {
    public int view() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Menu----");
        System.out.println("1. add");
        System.out.println("2. display");
        System.out.println("3. search");
        System.out.println("0. Edit");
        int choice = -1;
        do {
            try {
                System.out.println("input your choice");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" mời bạn chọn số nguyên từ 0->3");
            }
        } while (choice < 0 || choice > 3);

        return choice;
    }

    public Product viewAdd() throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        System.out.print("product Id: ");
        String id = sc.nextLine();
        System.out.print("product Name: ");
        String productName = sc.nextLine();
        System.out.print("product Price: ");
        double price = Double.parseDouble(sc.nextLine());
        if(price < 0 || price > 100000000){
            throw new NumberFormatException("giá bán phải lớn hơn 0");
        }
        System.out.print(" Producer: ");
        String producer = sc.nextLine();
        return new Product(id, productName, price, producer);
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("thành công");
        } else
            System.out.println("thất bại");
    }

    public void display(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public String inputID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id sản phẩm tìm kiếm: ");
        String id = sc.nextLine();
        return id;
    }

    public void displayProduct(Product product) {
        System.out.println(product.toString());
    }
}

