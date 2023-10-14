package assignment3;

public class EmptyArgumentException extends Exception{
    
    public EmptyArgumentException(){}

    public EmptyArgumentException(String message){
        super(message);
    }
}
