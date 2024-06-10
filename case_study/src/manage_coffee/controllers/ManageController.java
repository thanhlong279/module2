package manage_coffee.controllers;

import manage_coffee.models.*;
import manage_coffee.models.services.IService;
import manage_coffee.models.services.impl.ManageService;
import manage_coffee.views.ManageView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ManageController {
    public static void main(String[] args) {
        ManageView manageView = ManageView.getInstance();
        IService<Coffee> manageService = ManageService.getInstance();
        Auth auth = Auth.getInstance();
        int choice;
        int choiceProduct;
        Coffee product;
        boolean result;
        List<Bill> listBill;
        List<Coffee> coffeeList;
        String name;
        boolean isConfirm;
        String code;
        Coffee updateProduct;
        if(!manageView.authUser(auth)){
            manageView.messageAuthUser();
            return;
        }
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
                    listBill =  manageService.readFileSale();
                    manageView.viewSaleDate(listBill);
                    break;
                case 7:
                    LocalDate date = manageView.inputDate();
                    double totalSaleAmount = manageService.totalSaleAmount(date);
                    manageView.getTotalSaleAmount(totalSaleAmount);
                    break;
                case 0:
                    return;
            }
        }
    }
}
