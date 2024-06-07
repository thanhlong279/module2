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
}
