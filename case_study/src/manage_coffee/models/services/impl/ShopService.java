package manage_coffee.models.services.impl;

import manage_coffee.models.*;
import manage_coffee.models.repositories.RepositoryClient;
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
        return repositoryClient.getAllCart();
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

    @Override
    public boolean validateQuantityCart(List<CustomerCart> cartList) {
        List<Coffee> listCart = getAllCart();
        for (CustomerCart customerCart : cartList) {
            boolean isValid = true;
            for (Coffee coffee : listCart) {
                if (coffee instanceof HighlandsCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    if (((HighlandsCoffee) coffee).getQuantity() >= customerCart.getQuantity()) {
                        isValid = false;
                    }
                } if (coffee instanceof Nescafe && coffee.getCode().equals(customerCart.getCode())) {
                    if (((Nescafe) coffee).getQuantity() >= customerCart.getQuantity()) {
                        isValid = false;
                    }
                } if (coffee instanceof TrungNguyenCoffee && coffee.getCode().equals(customerCart.getCode())) {
                    if (((TrungNguyenCoffee) coffee).getWeight() >= customerCart.getQuantity()) {
                        isValid = false;
                    }
                }
            }
            if (!isValid) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getTotalMoney(List<CustomerCart> cartList) {
        return repositoryClient.getTotalMoney(cartList);
    }

    @Override
    public void updateListProduct(List<CustomerCart> cartList) {
        repositoryClient.updateFileProduct(cartList);
    }

    @Override
    public void updateListCart() {
        repositoryClient.updateFileCart();
    }


//    public double getTotalMoney(List<CustomerCart> cartList) {
//        double totalHighlandsCoffee = 0;
//        double totalTrungNguyenCoffee = 0;
//        double totalNescafe = 0;
//        List<Coffee> listCart = getAllCart();
//        for (CustomerCart customerCart : cartList) {
//            for (Coffee coffee : listCart) {
//                if (coffee instanceof HighlandsCoffee && coffee.getCode().equals(customerCart.getCode())) {
//                    totalHighlandsCoffee += coffee.getReadMoney() * customerCart.getQuantity();
//                } if (coffee instanceof Nescafe && coffee.getCode().equals(customerCart.getCode())) {
//                    totalNescafe += coffee.getReadMoney() * customerCart.getQuantity();
//                } if (coffee instanceof TrungNguyenCoffee && coffee.getCode().equals(customerCart.getCode())) {
//                    totalTrungNguyenCoffee += coffee.getReadMoney() * customerCart.getQuantity();
//                }
//            }
//        }
//        return totalNescafe + totalHighlandsCoffee + totalTrungNguyenCoffee;
//    }

}


