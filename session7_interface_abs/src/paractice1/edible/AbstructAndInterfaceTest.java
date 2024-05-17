package paractice1.edible;

import paractice1.animal.Animal;
import paractice1.animal.Chicken;
import paractice1.animal.Tiger;

public interface AbstructAndInterfaceTest {

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }

            Fruit[] fruit = new Fruit[2];
            fruit[0] = new Apple();
            fruit[1] = new Orange();
            for (Fruit fruits : fruit) {
                System.out.println(fruits.howToEat());
            }
        }
    }
}