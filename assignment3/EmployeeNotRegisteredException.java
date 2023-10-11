package assignment3;

public class EmployeeNotRegisteredException extends Exception {
    public EmployeeNotRegisteredException(String employeeID){
        super("Employee " + employeeID + " was not registered yet.");
    }

    public EmployeeNotRegisteredException(String message, String employeeID){
        super(message);
    }
}
