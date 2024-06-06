package manage_coffee.models;

import java.time.LocalDate;

public class HighlandsCoffee extends Coffee{
    private int cupCoffee;
    private int inventory;

    public HighlandsCoffee(){
    }

    public HighlandsCoffee(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, int cupCoffee, int inventory) {
        super(code, name, expiry, duration, manufacturingDate, price, discount);
        this.cupCoffee = cupCoffee;
        this.inventory = inventory;
    }

    public int getCupCoffee() {
        return cupCoffee;
    }

    public void setCupCoffee(int cupCoffee) {
        this.cupCoffee = cupCoffee;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(super.getExpiry());
    }

    @Override
    public double getReadMoney() {
        double readMoney;
        if(LocalDate.now().isAfter(getExpiryDate().minusMonths(super.getDuration())) || LocalDate.now().isEqual(getExpiryDate().minusMonths(super.getDuration()))) {
            readMoney = super.getPrice() * cupCoffee * (1 - (super.getDiscount() /100));
        }else{
            readMoney = super.getPrice() * cupCoffee;
        }
        return readMoney;
    }
}
