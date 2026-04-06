package zoopark.model;

import java.util.Objects;

public abstract class Animal implements Comparable<Animal> {
    private String name;
    private int age;
    private double weight;

    private static int totalAnimals;

    protected Animal(){
        totalAnimals++;
    }

    protected Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;

        totalAnimals++;
    }

    public abstract void makeSound();

    public String getInfo() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("Name: ").append(name).append("; ");
        strBuild.append("Age: ").append(age).append("; ");
        strBuild.append("Weight: ").append(weight).append("; ");

        return strBuild.toString();
    }

    // Setter
    public void setName(String value) {
        this.name = value;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public void setWeight(double value) {
        this.weight = value;
    }

    public void addWeight(double value) {
        this.weight += value;
    }

    // Getter
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Double.compare(weight, animal.weight) == 0 && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }

    @Override
    public int compareTo(Animal a) {
        return Integer.compare(age, a.getAge());
    }
}
