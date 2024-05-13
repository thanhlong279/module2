public class BillCoffee {
    private String nameCafe;
    private double price1Kg;
    private double mass;

    public BillCoffee(String nameCafe, double price1Kg, double mass) {
        this.nameCafe = nameCafe;
        this.price1Kg = price1Kg;
        this.mass = mass;
    }

    public double totalMoney(){
        return this.price1Kg*this.mass;
    }
}
