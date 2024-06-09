package manage_coffee.controllers;

import manage_coffee.models.*;
import manage_coffee.models.services.IService;
import manage_coffee.models.services.impl.ManageService;
import manage_coffee.views.ManageView;

import java.util.List;
import java.util.Scanner;

public class ManageController {
    public static void main(String[] args) {
        ManageView manageView = ManageView.getInstance();
        IService<Coffee> manageService = ManageService.getInstance();
        Auth auth = new Auth();
        Scanner sc = new Scanner(System.in);
        boolean authenticated = false;
        int logIn = 0;
        while (logIn < 5 && !authenticated) {
            System.out.println("đăng nhập tài khoản và mật khẩu");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (auth.authUser(username, password)) {
                authenticated = true;
                System.out.println("Đăng nhập thành công");
            } else {
                logIn++;
                System.out.println("tài khoản hoặc mật khẩu ko đúng " + (5 - logIn) + " lần thử");
            }
        }
        if (!authenticated) {
            System.out.println("sai quá nhiều, mời bạn thử lại sau");
            return;
        }


        int choice;
        int choiceProduct;
        Coffee product;
        boolean result;
        List<Coffee> coffeeList;
        String name;
        boolean isConfirm;
        String code;
        Coffee updateProduct;
        while (true) {
            choice = manageView.viewMenu();
            switch (choice) {
                case 1:
                    choiceProduct = manageView.viewCoffee();
                    if (choiceProduct == 1) {
                        product = manageView.addHighlandsCoffee();
                        result = manageService.addCoffee(product);
                        manageView.viewMassage(result);
                        break;
                    }
                    if (choiceProduct == 2) {
                        product = manageView.addNetcafe();
                        result = manageService.addCoffee(product);
                        manageView.viewMassage(result);
                        break;
                    }
                    if (choiceProduct == 3) {
                        product = manageView.addTrungNguyenCoffee();
                        result = manageService.addCoffee(product);
                        manageView.viewMassage(result);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    coffeeList = manageService.getAll();
                    manageView.display(coffeeList);
                    break;
                case 3:
                    name = manageView.inputSearch();
                    coffeeList = manageService.searchByName(name);
                    if (coffeeList.isEmpty()) {
                        manageView.viewMassageSearch();
                    } else {
                        manageView.display(coffeeList);
                    }
                    break;
                case 4:
                    code = manageView.inputSearch();
                    product = manageService.searchByCode(code);
                    if (product == null) {
                        manageView.viewMassageSearch();
                    } else {
                        isConfirm = manageView.confirm(product);
                        if (isConfirm) {
                            manageService.deleteProduct(code);
                            manageView.viewMassage(true);
                        }
                    }
                    break;
                case 5:
                    code = manageView.inputSearch();
                    product = manageService.searchByCode(code);
                    if (product == null) {
                        manageView.viewMassageSearch();
                    } else {
                        isConfirm = manageView.confirm(product);
                        if (isConfirm) {
                            if (product instanceof HighlandsCoffee) {
                                updateProduct = manageView.addHighlandsCoffee();
                                updateProduct.setCode(product.getCode());
                                manageService.editProduct(updateProduct);
                                manageView.viewMassage(true);
                            }
                            if (product instanceof Nescafe) {
                                updateProduct = manageView.addNetcafe();
                                updateProduct.setCode(product.getCode());
                                manageService.editProduct(updateProduct);
                                manageView.viewMassage(true);
                            }
                            if (product instanceof TrungNguyenCoffee) {
                                updateProduct = manageView.addTrungNguyenCoffee();
                                updateProduct.setCode(product.getCode());
                                manageService.editProduct(updateProduct);
                                manageView.viewMassage(true);
                            }
                        }
                    }
                    break;
                case 6:
                    manageService.readFileSale();
                    break;
                case 0:
                    return;
            }
        }
    }
}
