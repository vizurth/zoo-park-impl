package zoopark.model;

import zoopark.enums.ZooSection;

public class ZooEntry {
    private ZooSection section;
    private Animal animal;

    public ZooEntry(ZooSection section, Animal animal) {
        this.section = section;
        this.animal = animal;
    }

    public ZooSection getSection() {
        return section;
    }
    public Animal getAnimal() {
        return animal;
    }
}