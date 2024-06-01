package mvc_management_material.models.services;

import mvc_management_material.models.Material;
import mvc_management_material.view.ViewMamagement;

import java.util.List;

public interface IServices<T extends Material> {
    boolean addMaterial(T t);

    List<T> getAll();
    T findByID(String id);

    void deleteMaterial(T m);

    List<T> searchByName(String str);

    void editMaterial(T m);

    void totalMoneyDiscount();

    void totalNotMoneyDiscount();

    List<T> sortMaterialByPrince();

    boolean validateInput(T t);
}
