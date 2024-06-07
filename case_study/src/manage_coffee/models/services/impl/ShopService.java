package manage_coffee.models.services.impl;

import manage_coffee.models.Coffee;
import manage_coffee.models.repositories.RepositoryClient;
import manage_coffee.models.repositories.RepositoryManage;
import manage_coffee.models.services.shop.IShopService;

import java.util.ArrayList;
import java.util.List;

public class ShopService implements IShopService {
    private static ShopService instance;

    private ShopService() {
    }

    ;

    public synchronized static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopService();
        }
        return instance;
    }

    RepositoryClient repositoryClient = RepositoryClient.getInstance();

    @Override
    public List<Coffee> getAllProduct() {
        return repositoryClient.getAllProduct();
    }

    public List<Coffee> addCart(List<String> list) {
        return repositoryClient.addCart(list);
    }

    @Override
    public List<Coffee> getAllCart() {
        return repositoryClient.getAll();
    }

    @Override
    public void deleteProductInCart(List<String> list) {
        repositoryClient.deleteProductInCart(list);
    }

    @Override
    public List<Coffee> findByID(List<String> list) {
        List<Coffee> coffees = getAllCart();
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffees) {
            for (String str : list) {
                if (coffee.getCode().equals(str)) {
                    result.add(coffee);
                }
            }
        }
        return result;
    }

//    public List<Coffee> addCart(List<String> list) {
//        List<Coffee> coffees = getAll();
//        List<Coffee> result = new ArrayList<>();
//        int coffeesSize = coffees.size();
//        int listString = list.size();
//        for (int i = 0; i <  coffeesSize; i++) {
//            for (int j = 0; j < listString; j++) {
//                if(coffees.get(i).getCode().equalsIgnoreCase(list.get(j))){
//                    result.add(coffees.get(i));
//                }
//            }
//        }
//        return result;
//    }
}


