package zoopark.animals;

import zoopark.model.Animal;
import zoopark.interfaces.Feedable;
import zoopark.enums.PossibleFood;

public class Cat extends Animal implements Feedable {
    public Cat() {
        super();
    }

    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void eat(PossibleFood food) {
        if (food.isFish()) {
            System.out.println(super.getName() + " happily eats " + food);
        } else {
            System.out.println(super.getName() + " sniffs " + food + " and walks away...");
            return;
        }

        switch (food) {
            case FISH -> super.addWeight(0.3);
            case SHRIMP -> super.addWeight(0.2);
        }
    }
}
