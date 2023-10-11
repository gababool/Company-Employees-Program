package assignment3;

public class InvalidDeptException extends IllegalArgumentException {
    
    public InvalidDeptException(){
        super("Department must be one of the options: Business, Human Resources or Technical.");
    }

    public InvalidDeptException(String message) throws IllegalArgumentException{
        super(message);
    }
}
