package assignment3;

public class InvalidArgumentException extends Exception {
    
    public InvalidArgumentException(){}

    public InvalidArgumentException(String message) {
        super(message);
    }
}
