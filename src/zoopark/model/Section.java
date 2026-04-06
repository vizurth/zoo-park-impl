package zoopark.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section<T extends Animal> {
    private final String name;
    private final List<T> animals = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }

    public void add(T animal) {
        animals.add(animal);
    }

    public String getName() {
        return name;
    }

    public List<T> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}
