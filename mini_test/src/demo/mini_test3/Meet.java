package demo.mini_test3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meet extends Material {
    private double weight;

    public Meet() {
    }

    public Meet(double weight) {
        this.weight = weight;
    }

    public Meet(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
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
        return weight * super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney(LocalDate date) {
        double realMoney;
        if((LocalDate.now().isAfter(getExpiryDate().minusDays(5))||
                LocalDate.now().isEqual(getExpiryDate().minusDays(5)))){
            realMoney = getAmount() * 0.7;
        } else {
            realMoney = getAmount() * 0.9;
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return "Meet{" + super.toString()+
                "weight=" + weight +
                '}';
    }
}