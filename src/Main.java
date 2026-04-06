import zoopark.animals.Cat;
import zoopark.animals.Dog;
import zoopark.animals.Parrot;
import zoopark.enums.PossibleFood;
import zoopark.model.Animal;
import zoopark.model.Section;
import zoopark.model.Zoo;

import java.util.List;

public class Main {
   public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Dog dog = new Dog("Buddy", 3, 12.5);
        Dog dog1 = new Dog("BOBIK", 6, 16);
        Cat cat = new Cat("Whiskers", 5, 4.2);
        Parrot parrot = new Parrot("Kesha", 2, 0.8);

        Section<Animal> mammals = new Section<>("Mammals");
        Section<Parrot> birds = new Section<>("Birds");

        mammals.add(dog);
        mammals.add(dog1);
        mammals.add(cat);
        birds.add(parrot);

        zoo.addSection(mammals);
        zoo.addSection(birds);

        System.out.println("=== Feeding ===");
        dog.eat(PossibleFood.STEAK);
        dog.eat(PossibleFood.VEGETABLES);   // не ест
        cat.eat(PossibleFood.FISH);
        cat.eat(PossibleFood.STEAK);        // не ест
        parrot.eat(PossibleFood.SEEDS);
        parrot.eat(PossibleFood.RAW_MEAT);  // не ест

        System.out.println("\n=== Training ===");
        dog.train("sit");
        dog.train("shake");
        parrot.train("say hello");

        System.out.println("Buddy knows: " + dog.getCommands());
        System.out.println("Kesha knows: " + parrot.getCommands());

        System.out.println("\n=== All animals ===");
        zoo.printAllAnimals();

        System.out.println("\n=== Find by name ===");
        zoo.findByName("Buddy").ifPresentOrElse(
            entry -> System.out.println("Found: " + entry.getInfo()),
            () -> System.out.println("Not found")
        );

        zoo.findByName("Rex").ifPresentOrElse(
            entry -> System.out.println("Found: " + entry.getInfo()),
            () -> System.out.println("Rex not found")
        );

        System.out.println("\n=== Find Dog ===");
        List<Dog> dogs = zoo.getAnimalsByType(Dog.class);
        for (Dog d : dogs) {
            System.out.println(d.getInfo());
        }
    }
}
