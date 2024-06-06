package mvc_management_material.controllers;

import mvc_management_material.models.CrispyFlour;
import mvc_management_material.models.Material;
import mvc_management_material.models.Meat;
import mvc_management_material.models.services.ManagementService;
import mvc_management_material.view.ViewMamagement;

import java.util.List;

public class MaterialController {
    public static void main(String[] args) {
        ViewMamagement viewMamagement = new ViewMamagement();
        ManagementService managementService = new ManagementService();
        int choice;
        int choiceMaterial;
        Material material;
        boolean result;
        boolean isConfirm;
        String name;
        String id;
        List<Material> materials;
        while (true) {
            choice = viewMamagement.view();
            switch (choice) {
                case 1:
                    choiceMaterial = viewMamagement.viewMaterial();
                    switch (choiceMaterial) {
                        case 1:
                            material = viewMamagement.addCrispyFlour();
                            result = managementService.addMaterial(material);
                            viewMamagement.viewMasage(result);
                            break;
                        case 2:
                            material = viewMamagement.addMeat();
                            result = managementService.addMaterial(material);
                            viewMamagement.viewMasage(result);
                            break;
                        case 0:
                            return;
                    }
                    break;
                case 2:
                    id = viewMamagement.inputStr();
                    material = managementService.findByID(id);
                    if (material == null) {
                        viewMamagement.viewMasage(false);
                    } else {
                        isConfirm = viewMamagement.confirmDeleteEdit(material);
                        if (isConfirm) {
                            if (material instanceof CrispyFlour) {
                                Material updatedCrispyFlour = viewMamagement.addCrispyFlour();
                                updatedCrispyFlour.setId(material.getId()); // Giữ lại ID cũ
                                managementService.editMaterial(updatedCrispyFlour);
                                viewMamagement.viewMasage(true);
                            }
                            if (material instanceof Meat) {
                                Material updatedMeat = viewMamagement.addMeat();
                                updatedMeat.setId(material.getId()); // Giữ lại ID cũ
                                managementService.editMaterial(updatedMeat);
                                viewMamagement.viewMasage(true);
                            }
                        }
                    }
                    break;
                case 3:
                    id = viewMamagement.inputStr();
                    material = managementService.findByID(id);
                    if (material == null) {
                        viewMamagement.viewMasage(false);
                    } else {
                        isConfirm = viewMamagement.confirmDeleteEdit(material);
                        if (isConfirm) {
                            managementService.deleteMaterial(material);
                            viewMamagement.viewMasage(true);
                        }
                    }
                    break;
                case 4:
                    materials = managementService.getAll();
                    viewMamagement.displayMaterial(materials);
                    break;
                case 5:
                    name = viewMamagement.inputStr();
                    materials = managementService.searchByName(name);
                    if (materials.isEmpty()) {
                        viewMamagement.viewMasage(false);
                    } else {
                        viewMamagement.displayMaterial(materials);
                    }
                    break;
                case 6:
                    managementService.totalMoneyDiscount();
                    break;
                case 7:
                    managementService.totalNotMoneyDiscount();
                    break;
                case 8:
                    materials = managementService.sortMaterialByPrince();
                    viewMamagement.displayMaterial(materials);
                    break;
//                case 9:
//                    materials = managementService.getAll();
//                    managementService.writeFile(materials,true);
//                    break;
                case 0:
                    return;
            }
        }
    }
}
