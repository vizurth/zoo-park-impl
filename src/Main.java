import zoopark.animals.Cat;
import zoopark.animals.Dog;
import zoopark.animals.Parrot;
import zoopark.enums.PossibleFood;
import zoopark.model.Animal;
import zoopark.model.Section;
import zoopark.model.Zoo;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Dog dog = new Dog("Buddy", 3, 12.5);
        Dog dog1 = new Dog("Bobik", 6, 16.0);
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

        Cat lateCat = new Cat("Luna", 1, 3.0);
        mammals.add(lateCat);

        System.out.println("=== Feeding ===");
        dog.eat(PossibleFood.STEAK);
        dog.eat(PossibleFood.VEGETABLES);
        cat.eat(PossibleFood.FISH);
        cat.eat(PossibleFood.STEAK);
        parrot.eat(PossibleFood.SEEDS);
        parrot.eat(PossibleFood.RAW_MEAT);

        System.out.println("\n=== Training ===");
        dog.train("sit");
        dog.train("sit");       // дубликат — LinkedHashSet проигнорирует
        dog.train("shake");
        parrot.train("say hello");
        System.out.println("Buddy knows: " + dog.getCommands());
        System.out.println("Kesha knows: " + parrot.getCommands());

        System.out.println("\n=== All animals ===");
        zoo.printAllAnimals();

        System.out.println("=== Find by name ===");
        zoo.findByName("Buddy").ifPresentOrElse(
            a -> System.out.println("Found: " + a.getInfo()),
            () -> System.out.println("Not found")
        );
        zoo.findByName("Luna").ifPresentOrElse(
            a -> System.out.println("Found: " + a.getInfo()),
            () -> System.out.println("Luna not found")
        );
        zoo.findByName("Rex").ifPresentOrElse(
            a -> System.out.println("Found: " + a.getInfo()),
            () -> System.out.println("Rex not found")
        );

        System.out.println("\n=== All dogs ===");
        List<Dog> dogs = zoo.getAnimalsByType(Dog.class);
        for (Dog d : dogs) {
            System.out.println(d.getInfo());
        }

        System.out.println("\n=== Mammals sorted by age (Comparable) ===");
        mammals.getSortedAnimals(Comparator.naturalOrder()).forEach(
            a -> System.out.println(a.getName() + " — age: " + a.getAge())
        );

        System.out.println("\n=== Mammals sorted by weight (Comparator) ===");
        mammals.getSortedAnimals(Comparator.comparingDouble(Animal::getWeight)).forEach(
            a -> System.out.println(a.getName() + " — weight: " + a.getWeight())
        );
    }
}
