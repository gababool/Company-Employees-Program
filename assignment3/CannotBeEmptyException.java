package assignment3;

public class CannotBeEmptyException extends Exception{
    public CannotBeEmptyException(){}

    public CannotBeEmptyException(String message){
        super(message);
    }
}
