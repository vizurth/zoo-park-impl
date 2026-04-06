package zoopark.model;

import zoopark.exceptions.AnimalAlreadyExistsException;
import zoopark.exceptions.AnimalNotFoundException;
import zoopark.interfaces.Trainable;

import java.util.*;

public class Zoo {
    private List<Section<? extends Animal>> sections;
    private Map<String, Animal> animalMap;

    public Zoo() {
        sections = new ArrayList<>();
        animalMap = new HashMap<>();
    }

    public <T extends Animal> void addSection(Section<T> section) {
        sections.add(section);
        for (Animal a : section.getAnimals()) {
            registerAnimal(a);
        }
        section.setOnAdd(this::registerAnimal);
    }

    private void registerAnimal(Animal animal) {
        if (animalMap.containsKey(animal.getName())) {
            throw new AnimalAlreadyExistsException(animal.getName());
        }
        animalMap.put(animal.getName(), animal);
    }

    public void printAllAnimals() {
        for (Section<? extends Animal> s : sections) {
            for (Animal a : s.getAnimals()) {
                System.out.println("[" + s.getName() + "]" + a.getInfo());
                System.out.print("Sound:");
                a.makeSound();
                boolean trainable = (a instanceof Trainable);
                System.out.println("Can be trained:" + trainable);
                System.out.println();
            }
        }
    }

    public Optional<Animal> findByName(String name) {
        return Optional.ofNullable(this.animalMap.get(name));
    }

    public Animal getByName(String name) {
        Animal animal = animalMap.get(name);
        if (animal == null) throw new AnimalNotFoundException(name);
        return animal;
    }

    public <T extends Animal> List<T> getAnimalsByType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (Section<? extends Animal> s : sections) {
            for (Animal a : s.getAnimals()) {
                if (type.isInstance(a)) {
                    result.add(type.cast(a));
                }
            }
        }

        return result;
    }
}
