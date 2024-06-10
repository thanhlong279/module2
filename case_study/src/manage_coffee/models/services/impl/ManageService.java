package manage_coffee.models.services.impl;

import manage_coffee.models.Bill;
import manage_coffee.models.Coffee;
import manage_coffee.models.FinishedCoffee;
import manage_coffee.models.TrungNguyenCoffee;
import manage_coffee.models.repositories.ManageRepository;
import manage_coffee.models.services.manage.IManageService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageService implements IManageService {
    private ManageRepository repositoryCoffee = ManageRepository.getInstance();
    private static ManageService instance;

    private ManageService() {
    }

    public synchronized static ManageService getInstance() {
        if (instance == null) {
            instance = new ManageService();
        }
        return instance;
    }

    @Override
    public boolean addCoffee(Coffee coffee) {
        if (validateCoffee(coffee)) {
            repositoryCoffee.addCoffee(coffee);
            return true;
        }
        return false;
    }

    @Override
    public boolean validateCoffee(Coffee coffee) {
        List<Coffee> lists = getAll();
        if (coffee.getCode().equals("")) {
            return false;
        }
        if (coffee.getName().equals("")) {
            return false;
        }
        if (coffee.getPrice() < 0) {
            return false;
        }
        if (coffee.getExpiry() <= 0) {
            return false;
        }
        if (coffee.getDiscount() < 0) {
            return false;
        }
        if (coffee.getDuration() < 0) {
            return false;
        }
        if (coffee.getExpiry() < coffee.getDuration()) {
            return false;
        }
        if (coffee instanceof FinishedCoffee) {
            if (((FinishedCoffee) coffee).getQuantity() < 0) {
                return false;
            }
        }
        if (coffee instanceof TrungNguyenCoffee) {
            if (((TrungNguyenCoffee) coffee).getWeight() < 0) {
                return false;
            }
        }
        for (Coffee list : lists) {
            if (coffee.getCode().equals(list.getCode())) {
                return false;
            }
        }
        return true;
    }
    @Override
    public List<Coffee> getAll() {
        return repositoryCoffee.getAll();
    }

    @Override
    public List<Coffee> searchByName(String name) {
        List<Coffee> list = getAll();
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : list) {
            if(coffee.getName().contains(name)){
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public Coffee searchByCode(String code) {
        List<Coffee> list = getAll();
        for (Coffee coffee : list) {
            if (coffee.getCode().equals(code)) {
                return coffee;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(String code) {
        repositoryCoffee.deleteCoffee(code);
    }

    @Override
    public void editProduct(Coffee coffee) {
        repositoryCoffee.editProduct(coffee);
    }

    @Override
    public List<Bill> readFileSale() {
        return repositoryCoffee.readFileSale();
    }

    @Override
    public double totalSaleAmount(LocalDate date) {
        return repositoryCoffee.getTotalSaleAmount(date);
    }

}

