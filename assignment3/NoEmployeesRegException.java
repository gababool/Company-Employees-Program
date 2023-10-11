package assignment3;

public class NoEmployeesRegException extends NullPointerException {
    public NoEmployeesRegException(){
        super("No employees registered yet.");
    }

    public NoEmployeesRegException(String message) throws NullPointerException{
        super(message);
    }
}
