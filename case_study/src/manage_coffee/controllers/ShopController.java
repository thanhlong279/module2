package manage_coffee.controllers;

import manage_coffee.models.Coffee;
import manage_coffee.models.CustomerCart;
import manage_coffee.models.services.impl.ShopService;
import manage_coffee.models.services.shop.IShopService;
import manage_coffee.views.ShopView;

import java.util.List;

public class ShopController {
    public static void main(String[] args) {
        ShopView viewShop = ShopView.getInstance();
        IShopService shopService = ShopService.getInstance();
        List<Coffee> coffees;
        List<String> list;
        List<CustomerCart> cartList;
        boolean result;
        int choice;
        double totalMoney = 0;
        boolean isconfirm;
        coffees = shopService.getAllProduct();
        viewShop.viewProduct(coffees);

        while (true) {
            choice = viewShop.viewMenu();
            switch (choice) {
                case 1:
                    list = viewShop.addCart();
                    coffees = shopService.addCart(list);
                    if (coffees.isEmpty()) {
                        System.out.println("ko có sản phẩm bạn chọn trong cửa hàng");
                    } else {
                        viewShop.viewCart(shopService.getAllCart());
                    }
                    break;
                case 2:
                    List<Coffee> listCart = shopService.getAllCart();
                    viewShop.viewCart(listCart);
                    list = viewShop.deleteCart();
                    coffees = shopService.findByID(list);
                    if (coffees.isEmpty()) {
                        System.out.println("ko có sản phẩm bạn trọn trong giỏ hàng");
                    } else {
                        result = viewShop.confirmDeleteInCart(coffees);
                        if (result) {
                            shopService.deleteProductInCart(list);
                            viewShop.viewMassageCart(true);
                            System.out.println("sản phẩm trong giỏ hàng của bạn: ");
                            viewShop.viewCart(shopService.getAllCart());
                        }
                        break;
                    }
                case 3:
                    viewShop.viewCart(shopService.getAllCart());
                    break;
                case 4:
                    coffees = shopService.getAllCart();
                    cartList = viewShop.getAmount(coffees);
                    result = shopService.validateQuantityCart(cartList);
                    if (result) {
                        viewShop.viewMassageValidateCart();
                        cartList = viewShop.getAmount(coffees);
                    } else {
                        isconfirm = viewShop.confirmGetAmount(cartList);
                        if (isconfirm) {
                            totalMoney = shopService.getTotalMoney(cartList);
                            shopService.updateListProduct(cartList);
                            shopService.updateSaleData(cartList);
                            viewShop.getTotalMoney(cartList, totalMoney);
                            shopService.updateListCart();
                            viewShop.viewProduct(coffees);
                        }
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}