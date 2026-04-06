package zoopark.model;

import java.util.*;
import java.util.function.Consumer;

public class Section<T extends Animal> {
    private final String name;
    private final List<T> animals = new ArrayList<>();
    private Consumer<T> onAdd;

    public Section(String name) {
        this.name = name;
    }

    public void add(T animal) {
        animals.add(animal);
        if (onAdd != null) {
            onAdd.accept(animal);
        }
    }

    public void setOnAdd(Consumer<T> onAdd) {
        this.onAdd = onAdd;
    }

    public String getName() {
        return name;
    }

    public List<T> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public List<T> getSortedAnimals(Comparator<T> comparator) {
        List<T> sorted = new ArrayList<>(animals);
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Section<?> section = (Section<?>) o;
        return Objects.equals(name, section.name) && Objects.equals(animals, section.animals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, animals);
    }
}
