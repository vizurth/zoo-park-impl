package zoopark.model;

public abstract class Animal {
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

        strBuild.append("Name: ").append(name).append(" ");
        strBuild.append("Age: ").append(age).append(" ");
        strBuild.append("Weight: ").append(weight).append(" ");

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

}
