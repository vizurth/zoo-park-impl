package zoopark.model;

import zoopark.interfaces.Trainable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zoo {
    private List<Section<? extends Animal>> sections;

    public Zoo() {
        sections = new ArrayList<>();
    }

    public <T extends Animal> void addSection(Section<T> section) {
        sections.add(section);
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
        for (Section<? extends Animal> s : sections) {
            for (Animal a : s.getAnimals()) {
                if (a.getName().equals(name)) {
                    return Optional.of(a);
                }
            }
        }

        return Optional.empty();
    }

    public <T extends Animal> List<T> getAnimalsByType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (Section<? extends Animal> s :sections) {
            for (Animal a : s.getAnimals()) {
                if (type.isInstance(a)) {
                    result.add(type.cast(a));
                }
            }
        }

        return result;
    }
}
