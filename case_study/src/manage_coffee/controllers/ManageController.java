package manage_coffee.controllers;

import manage_coffee.models.Coffee;
import manage_coffee.models.services.IService;
import manage_coffee.models.services.impl.ManageService;
import manage_coffee.views.ManageView;

import java.util.List;

public class ManageController {
    public static void main(String[] args) {
        ManageView manageView = ManageView.getInstance();
        IService<Coffee> manageService = ManageService.getInstance();
        int choice;
        int choiceProduct;
        Coffee product;
        boolean result;
        List<Coffee> coffeeList;
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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
            }
        }
    }
}
