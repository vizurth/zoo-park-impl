package zoopark.exceptions;

public class AnimalAlreadyExistsException extends RuntimeException {
    public AnimalAlreadyExistsException(String name) {
        super("Animal with name " + name + " already exists");
    }
}
