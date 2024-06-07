package manage_coffee.models.services.impl;

import manage_coffee.models.Coffee;
import manage_coffee.models.repositories.RepositoryManage;
import manage_coffee.models.services.manage.IManageService;

import java.util.List;

public class ManageService implements IManageService {
    private RepositoryManage repositoryCoffee = RepositoryManage.getInstance();
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
        return true;
    }

    @Override
    public List<Coffee> getAll() {
        return repositoryCoffee.getAll();
    }

}

