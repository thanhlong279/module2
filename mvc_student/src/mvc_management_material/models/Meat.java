package mvc_management_material.models;

import java.time.LocalDate;

public class Meat extends Material{
    private double weight;

    public Meat(){
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight*super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }

    @Override
    public String toString() {
        return
                super.toString()+
                " weight=" + weight +
                ',';
    }

    @Override
    public double getRealMoney(LocalDate now) {
        double realMoney;
        if((LocalDate.now().isAfter(getExpiryDate().minusDays(5))||
                LocalDate.now().isEqual(getExpiryDate().minusDays(5)))){
            realMoney = getAmount() * 0.7;
        } else {
            realMoney = getAmount() * 0.9;
        }
        return realMoney;
    }


}
