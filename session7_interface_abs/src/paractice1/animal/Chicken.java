package paractice1.animal;

import paractice1.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound(){
        return "cluck";
    }
    @Override
    public String howToEat(){
        return "could be fried";
    }
}
