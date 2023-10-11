package assignment3;

public class NoEmployeesRegException extends Exception{
    public NoEmployeesRegException(){
        super("No employees registered yet.");
    }

    public NoEmployeesRegException(String message){
        super(message);
    }
}
