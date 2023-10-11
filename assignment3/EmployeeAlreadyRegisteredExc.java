package assignment3;

public class EmployeeAlreadyRegisteredExc extends IllegalArgumentException{
    public EmployeeAlreadyRegisteredExc(String employeeID){
        super("Cannot register. ID " + employeeID + " is already registered.");
    }

    public EmployeeAlreadyRegisteredExc(String message, String employeeID) throws IllegalArgumentException{
        super(message);
    }
}
