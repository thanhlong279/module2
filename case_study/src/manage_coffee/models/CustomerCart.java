package manage_coffee.models;

public class CustomerCart {
    private String code;
    private double quantity;

    public CustomerCart() {
    }

    public CustomerCart(String code, double quantity) {
        this.code = code;
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

    @Override
    public String toString() {
        return "CustomerCart{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

