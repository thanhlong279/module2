package manage_coffee.models;

import java.time.LocalDate;

public class Nescafe extends Coffee {
    private int boxCoffee;
    private int inventory;

    public Nescafe() {
    }

    public Nescafe(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, int boxCoffee, int inventory) {
        super(code, name, expiry, duration, manufacturingDate, price, discount);
        this.boxCoffee = boxCoffee;
        this.inventory = inventory;
    }

    public int getBoxCoffee() {
        return boxCoffee;
    }

    public void setBoxCoffee(int boxCoffee) {
        this.boxCoffee = boxCoffee;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(super.getExpiry());
    }

    @Override
    public double getReadMoney() {
        double readMoney;
        if(LocalDate.now().isAfter(getExpiryDate().minusMonths(super.getDuration())) || LocalDate.now().isEqual(getExpiryDate().minusMonths(super.getDuration()))) {
            readMoney = super.getPrice() * boxCoffee * (1 - super.getDiscount() /100);
        }else{
            readMoney = super.getPrice() * boxCoffee;
        }
        return readMoney;
    }
}
