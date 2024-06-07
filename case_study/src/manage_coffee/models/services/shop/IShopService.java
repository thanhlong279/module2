package manage_coffee.models.services.shop;

import manage_coffee.models.Coffee;
import manage_coffee.models.services.IService;

import java.util.List;

public interface IShopService {

    List<Coffee> getAllProduct();

    List<Coffee> addCart(List<String> list);

    List<Coffee> getAllCart();

    void deleteProductInCart(List<String> list);

    List<Coffee> findByID(List<String> list);
//    List<Coffee> validateCart(String list);
}

