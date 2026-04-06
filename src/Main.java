import zoopark.animals.Cat;
import zoopark.animals.Dog;
import zoopark.animals.Parrot;
import zoopark.enums.PossibleFood;
import zoopark.enums.ZooSection;
import zoopark.model.Zoo;

public class Main {
    static void main(String[] args) {
        Zoo zoo = new Zoo();

        Dog dog = new Dog("Buddy", 3, 12.5);
        Cat cat = new Cat("Whiskers", 5, 4.2);
        Parrot parrot = new Parrot("Kesha", 2, 0.8);

        zoo.addAnimal(dog, ZooSection.MAMMALS);
        zoo.addAnimal(cat, ZooSection.MAMMALS);
        zoo.addAnimal(parrot, ZooSection.BIRDS);

        // --- Кормим животных ---
        System.out.println("=== Feeding ===");
        dog.eat(PossibleFood.STEAK);
        dog.eat(PossibleFood.VEGETABLES);   // не ест
        cat.eat(PossibleFood.FISH);
        cat.eat(PossibleFood.STEAK);        // не ест
        parrot.eat(PossibleFood.SEEDS);
        parrot.eat(PossibleFood.RAW_MEAT);  // не ест

        // --- Тренируем тех, кто умеет ---
        System.out.println("\n=== Training ===");
        dog.train("sit");
        dog.train("shake");
        parrot.train("say hello");

        System.out.println("Buddy knows: " + dog.getCommands());
        System.out.println("Kesha knows: " + parrot.getCommands());

        // --- Выводим всех животных ---
        System.out.println("\n=== All animals ===");
        zoo.printAllAnimals();

        // --- Поиск по имени ---
        System.out.println("\n=== Find by name ===");
        zoo.findByName("Buddy").ifPresentOrElse(
            entry -> System.out.println("Found: " + entry.getAnimal().getInfo()),
            () -> System.out.println("Not found")
        );

        zoo.findByName("Rex").ifPresentOrElse(
            entry -> System.out.println("Found: " + entry.getAnimal().getInfo()),
            () -> System.out.println("Rex not found")
        );
    }
}
