package mvc_management_material.models.services;
import mvc_management_material.models.CrispyFlour;
import mvc_management_material.models.Material;
import mvc_management_material.models.Meat;
import mvc_management_material.models.repositories.ManagementRipository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagementService implements IManagement{
    ManagementRipository managementRipository = new ManagementRipository();

    @Override
    public boolean validateInput(Material material) {
        List<Material> materials = getAll();
        if(material.getName().equals("")){
            return false;
        }
        if(material.getId().equals("")){
            return false;
        }
        if(material.getCost() <= 0){
            return false;
        }
        for (Material m : materials) {
            if(material.getId().equals(m.getId())){
                return false;
            }
//            if(m instanceof CrispyFlour){
//                CrispyFlour crispyFlour = (CrispyFlour) material;
//                if(crispyFlour.getQuantity() <= 0){
//                    return false;
//                }
//            }
//            if(m instanceof Meat){
//                Meat meat = (Meat) material;
//                if(meat.getWeight() <= 0){
//                    return false;
//                }
//            }
        }
        return true;
    }

    @Override
    public boolean addMaterial(Material material) {
        if(validateInput(material)){
            managementRipository.addMaterial(material);
            return true;
        }
        return false;
    }

    @Override
    public List<Material> getAll() {
        return managementRipository.copyList();
    }

    public Material findByID(String id) {
        return managementRipository.findByID(id);
    }

    @Override
    public void deleteMaterial(Material material) {
        managementRipository.removeMaterial(material);
    }

    @Override
    public List<Material> searchByName(String str) {
        List<Material> materials = this.getAll();
        List<Material> result = new ArrayList<>();
        for(Material material : materials){
            if(material.getName().contains(str)){
                result.add(material);
            }
        }
        return result;
    }

    @Override
    public void editMaterial(Material material) {
        managementRipository.editMaterial(material);
    }

    @Override
    public void totalMoneyDiscount() {
        managementRipository.totalMoneyDiscount();
    }

    @Override
    public void totalNotMoneyDiscount() {
        managementRipository.totalNotMoneyDiscount();
    }

    @Override
    public List<Material> sortMaterialByPrince() {
        List<Material> materials = managementRipository.copyList();
            Collections.sort(materials, new Comparator<Material>() {
                @Override
                public int compare(Material o1, Material o2) {
                    return (int) (o1.getRealMoney(LocalDate.now()) - o2.getRealMoney(LocalDate.now()));
                }
            });
            return materials;
        }
//        public void writeFile(List<Material> materials, boolean append) {
//        managementRipository.writeFile(materials, append);
//        }
}
