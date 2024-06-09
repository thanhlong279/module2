package manage_coffee.models;

import java.time.LocalDate;

public abstract class Coffee {
    private String code;
    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private int expiry;
    private double discount;
    private int duration;

    public Coffee(String code, String name, int expiry, int duration, LocalDate manufacturingDate, double price, double discount) {
        this.code = code;
        this.expiry = expiry;
        this.manufacturingDate = manufacturingDate;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.duration = duration;
    }

    public Coffee() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public int getExpiry() {
        return expiry;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return
                "code='" + code + '\'' +
                        ", name='" + name + '\'' +
                        ", date" + manufacturingDate +
                        ", price=" + price +
                        ", expiry=" + expiry +
                        ", duration=" + duration +
                        ", discount=" + discount +
                        ',';
    }

    public abstract LocalDate getExpiryDate();

    public abstract double getReadMoney();
}
