package zoopark.model;

import zoopark.interfaces.Trainable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TrainableAnimal extends Animal implements Trainable {
    private final List<String> commands = new ArrayList<>();

    protected TrainableAnimal() {
        super();
    }

    protected TrainableAnimal(String name, int age, double weight) {
        super(name, age, weight);
    }

    public List<String> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    @Override
    public void train(String command) {
        commands.add(command);
    }

}
