package assignment3;

public class EmployeeAlreadyRegisteredExc extends Exception{
    public EmployeeAlreadyRegisteredExc(String employeeID){
        super("Cannot register. ID " + employeeID + " is already registered.");
    }

    public EmployeeAlreadyRegisteredExc(String message, String employeeID) {
        super(message);
    }
}
