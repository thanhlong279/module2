package manage_coffee.models;

public class CustomerCart {
    private String code;
    private String name;
    private double quantity;

    public CustomerCart() {
    }

    public CustomerCart(String code, String name, double quantity) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerCart{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

