package zoopark.animals;

import zoopark.interfaces.Feedable;
import zoopark.enums.PossibleFood;
import zoopark.model.TrainableAnimal;

public class Dog extends TrainableAnimal implements Feedable {

    public Dog() {
        super();
    }

    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }


    @Override
    public void eat(PossibleFood food) {
        if (food.isMeat()) {
            System.out.println(super.getName() + " happily eats " + food);
        } else {
            System.out.println(super.getName() + " sniffs " + food + " and walks away...");
            return;
        }

        switch (food) {
            case RAW_MEAT -> super.addWeight(0.3);
            case STEAK -> super.addWeight(0.2);
            case CHICKEN -> super.addWeight(0.1);
        }
    }

}
