package assignment3;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException(){
        super("Name cannot be blank.");
    }
    public EmptyNameException(String message) throws IllegalArgumentException{
        super(message);
    }
}

