package manage_coffee.models.services;

import manage_coffee.models.Coffee;

import java.util.List;

public interface IService<T extends Coffee> {
    boolean addCoffee(T t);

    boolean validateCoffee(T t);

    List<Coffee> getAll();
}
