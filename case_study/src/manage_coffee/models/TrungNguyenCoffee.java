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
            readMoney = super.getPrice() * (1 - super.getDiscount() / 100);
        } else {
            readMoney = super.getPrice();
        }
        return readMoney;
    }

    @Override
    public String toString() {
        return super.toString() + " weight: " + weight;
    }
    @Override
    public void printManage() {
        System.out.printf("code=%-6s name=%-8s date=%-14s price=%-10.0f expiry=%-5d duration=%-6d discount=%-10.0f weight=%-8.0f%n",
                getCode(), getName(), getManufacturingDate(), getPrice(), getExpiry(), getDuration(), getDiscount(), weight);}
    public void printShop() {
        System.out.printf("code=%-6s name=%-8s date=%-14s price=%-10.0f expiry=%-5d discount=%-10.0f weight=%-8.0f%n",
                getCode(), getName(), getManufacturingDate(), getPrice(), getExpiry(), getDiscount(), weight);}

}
