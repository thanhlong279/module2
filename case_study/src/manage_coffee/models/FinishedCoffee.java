package manage_coffee.models;

import java.time.LocalDate;

public abstract class FinishedCoffee extends Coffee {
    private int quantity;

    public FinishedCoffee() {
    }

    public FinishedCoffee(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, int quantity) {
        super(code, name, expiry, duration, manufacturingDate, price, discount);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() + " Quantity: " + quantity;
    }
    @Override
    public void printManage() {
        System.out.printf("code=%-6s name=%-8s date=%-14s price=%-10.1f expiry=%-5d duration=%-6d discount=%-10.1f quantity=%-8d%n",
                getCode(), getName(), getManufacturingDate(), getPrice(), getExpiry(), getDuration(), getDiscount(), quantity);}
    public void printShop() {
        System.out.printf("code=%-6s name=%-8s date=%-14s price=%-10.0f expiry=%-5d discount=%-10.0f quantity=%-8d%n",
                getCode(), getName(), getManufacturingDate(), getPrice(), getExpiry(), getDiscount(), quantity);}
}
