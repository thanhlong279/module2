package manage_coffee.models;

import java.time.LocalDate;

public class TrungNguyenCoffee extends Coffee {
    private double weight;

    public TrungNguyenCoffee() {
    }

    public TrungNguyenCoffee(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, double weight) {
        super(code, name, expiry, duration, manufacturingDate, price, discount);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusMonths(super.getExpiry());
    }

    @Override
    public double getReadMoney() {
        double readMoney;
        if (LocalDate.now().isAfter(getExpiryDate().minusMonths(super.getDuration())) || LocalDate.now().isEqual(getExpiryDate().minusMonths(super.getDuration()))) {
            readMoney = super.getPrice() * weight * (1 - (super.getDiscount() / 100));
        } else {
            readMoney = super.getPrice() * weight;
        }
        return readMoney;
    }

    @Override
    public String toString() {
        return super.toString() + " weight: " + weight;
    }
}
