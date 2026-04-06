package zoopark.model;

import zoopark.interfaces.Trainable;

import java.util.*;

public abstract class TrainableAnimal extends Animal implements Trainable {
    private final Set<String> commands = new LinkedHashSet<>();

    protected TrainableAnimal() {
        super();
    }

    protected TrainableAnimal(String name, int age, double weight) {
        super(name, age, weight);
    }

    public Set<String> getCommands() {
        return Collections.unmodifiableSet(commands);
    }

    @Override
    public void train(String command) {
        commands.add(command);
    }

}
