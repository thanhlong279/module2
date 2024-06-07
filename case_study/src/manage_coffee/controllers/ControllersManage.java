package manage_coffee.controllers;

import manage_coffee.models.Coffee;
import manage_coffee.models.services.IService;
import manage_coffee.models.services.impl.ManageService;
import manage_coffee.models.services.impl.ShopService;
import manage_coffee.views.ViewManage;

import java.util.List;

public class ControllersManage {
    public static void main(String[] args) {
        ViewManage viewCoffee = ViewManage.getInstance();
        IService<Coffee> manageCoffee = ManageService.getInstance();
        int choice;
        int choiceCoffee;
        Coffee coffee;
        boolean result;
        List<Coffee> coffeeList;
        while (true) {
            choice = viewCoffee.viewMenu();
            switch (choice) {
                case 1:
                    choiceCoffee = viewCoffee.viewCoffee();
                    if (choiceCoffee == 1) {
                        coffee = viewCoffee.addHighlandsCoffee();
                        result = manageCoffee.addCoffee(coffee);
                        viewCoffee.viewMassage(result);
                        break;
                    }
                    if (choiceCoffee == 2) {
                        coffee = viewCoffee.addNetcafe();
                        result = manageCoffee.addCoffee(coffee);
                        viewCoffee.viewMassage(result);
                        break;
                    }
                    if (choiceCoffee == 3) {
                        coffee = viewCoffee.addTrungNguyenCoffee();
                        result = manageCoffee.addCoffee(coffee);
                        viewCoffee.viewMassage(result);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    coffeeList = manageCoffee.getAll();
                    viewCoffee.display(coffeeList);
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
