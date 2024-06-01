package mvc_management_material.models;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour(){
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity*super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney(LocalDate now) {
        double realMoney;
        if((LocalDate.now().isAfter(getExpiryDate().minusMonths(4))||
                LocalDate.now().isEqual(getExpiryDate().minusMonths(4)))){
            realMoney = getAmount() * 0.8;
        } else {
            realMoney = getAmount() * 0.95;
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                " quantity=" + quantity +
                ',';
    }
}
