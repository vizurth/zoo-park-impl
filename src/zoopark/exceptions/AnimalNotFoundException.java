package zoopark.exceptions;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String name) {
        super("Animal with name " + name + " not found");
    }
}
