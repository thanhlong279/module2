package manage_coffee.models;

import java.time.LocalDate;

public class Nescafe extends FinishedCoffee {
//    private int quantity;
//
//    public Nescafe() {
//    }
//
//    public Nescafe(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, int boxCoffee) {
//        super(code, name, expiry, duration, manufacturingDate, price, discount);
//        this.quantity = boxCoffee;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }


    public Nescafe() {
    }

    public Nescafe(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount, int quantity) {
        super(code, name, expiry, duration, manufacturingDate, price, discount, quantity);
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusMonths(super.getExpiry());
    }

    @Override
    public double getReadMoney() {
        double readMoney;
        if (LocalDate.now().isAfter(getExpiryDate().minusMonths(super.getDuration())) || LocalDate.now().isEqual(getExpiryDate().minusMonths(super.getDuration()))) {
            readMoney = super.getPrice() * super.getQuantity() * (1 - super.getDiscount() / 100);
        } else {
            readMoney = super.getPrice() * super.getQuantity();
        }
        return readMoney;
    }

}
