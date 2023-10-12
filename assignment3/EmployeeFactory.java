package assignment3;

public class EmployeeFactory {

   public static Employee createEmployee(String employeeID, String employeeName, double grossSalary) throws CannotBeEmptyException, InvalidArgumentException{
        return new Employee(employeeID, employeeName, grossSalary);
    }
    
    public static Manager createManager(String employeeID, String employeeName, double grossSalary, String degree) throws InvalidArgumentException, CannotBeEmptyException{
        return new Manager(employeeID, employeeName, grossSalary, degree);
    }

    public static Director createDirector(String employeeID, String employeeName, double grossSalary, String degree, String department) throws InvalidArgumentException, CannotBeEmptyException{
        return new Director(employeeID, employeeName, grossSalary, degree, department);
    }

    public static Intern createIntern(String employeeID, String employeeName, double grossSalary, int GPA) throws EmployeeRegistryException, CannotBeEmptyException, InvalidArgumentException {
        return new Intern(employeeID, employeeName, grossSalary, GPA);
    }

}
