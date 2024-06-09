package manage_coffee.models.services.shop;

import manage_coffee.models.Coffee;
import manage_coffee.models.CustomerCart;
import manage_coffee.models.services.IService;

import java.util.List;
import java.util.Map;

public interface IShopService {

    List<Coffee> getAllProduct();

    List<Coffee> addCart(List<String> list);

    List<Coffee> getAllCart();

    void deleteProductInCart(List<String> list);

    List<Coffee> findByID(List<String> list);

    boolean validateQuantityCart(List<CustomerCart> cartList);

    double getTotalMoney(List<CustomerCart> cartList);

    void updateListProduct(List<CustomerCart> cartList);

    void updateListCart();

    void updateSaleData(List<CustomerCart> customerCart);

}

