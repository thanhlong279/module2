package manage_coffee.models.services;

import manage_coffee.models.Bill;
import manage_coffee.models.Coffee;

import java.time.LocalDate;
import java.util.List;

public interface IService<T extends Coffee> {
    boolean
    addCoffee(T t);

    boolean validateCoffee(T t);

    List<Coffee> getAll();

    List<T> searchByName(String name);

    T searchByCode(String name);

    void deleteProduct(String name);

    void editProduct(T t);

    List<Bill> readFileSale();

    double totalSaleAmount(LocalDate date);

    boolean validateDateSale(LocalDate date);
}
