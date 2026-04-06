package zoopark.animals;

import zoopark.interfaces.Feedable;
import zoopark.enums.PossibleFood;
import zoopark.model.TrainableAnimal;

public class Parrot extends TrainableAnimal implements Feedable {

    public Parrot() {
        super();
    }

    public Parrot(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Hello");
    }

    @Override
    public void eat(PossibleFood food) {
        if (food.isPlantBased() || food.isInsects()) {
            System.out.println(super.getName() + " happily eats " + food);
        } else {
            System.out.println(super.getName() + " sniffs " + food + " and walks away...");
            return;
        }

        switch (food) {
            case VEGETABLES -> super.addWeight(0.3);
            case LEAVES -> super.addWeight(0.2);
        }
    }

}
