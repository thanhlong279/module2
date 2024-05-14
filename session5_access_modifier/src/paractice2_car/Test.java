package paractice2_car;

public class Test {
    public static void main(String[] args) {
        Car c1 = new Car("mazda", "3");
        System.out.println(Car.numberOfCars);

        Car c2 = new Car("Kia", "K3");
        System.out.println(Car.numberOfCars);
    }
}
