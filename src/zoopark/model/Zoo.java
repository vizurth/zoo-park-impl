package zoopark.model;

import zoopark.interfaces.Trainable;
import zoopark.enums.ZooSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zoo {
    private ArrayList<ZooEntry> animals;

    public Zoo() {
        animals = new ArrayList<ZooEntry>();
    }

    public void addAnimal(Animal a, ZooSection section){
        animals.add(new ZooEntry(section, a));
    }

    public void printAllAnimals() {
        for (ZooEntry ze : animals) {
            System.out.println("[" + ze.getSection() + "]" + ze.getAnimal().getInfo());
            System.out.print("Sound:");
            ze.getAnimal().makeSound();
            boolean trainable = (ze.getAnimal() instanceof Trainable);
            System.out.println("Can be trained:" + trainable);
            System.out.println();
        }
    }

    public Optional<ZooEntry> findByName(String name) {
        for (ZooEntry ze : animals) {
            if (ze.getAnimal().getName().equals(name)) {
                return Optional.of(ze);
            }
        }

        return Optional.empty();
    }

    public <T extends Animal> List<T> getAnimalsByType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (ZooEntry ze : animals) {
            if (type.isInstance(ze.getAnimal())) {
                result.add(type.cast(ze.getAnimal()));
            }
        }
        return result;
    }
}
