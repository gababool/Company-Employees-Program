package assignment3;

public class EmployeeFactory {

    EmployeeFactory(){}

   // Creates regular employee
   public Employee createEmployee(String employeeID, String employeeName, double grossSalary) throws CannotBeEmptyException, InvalidArgumentException{
        return new Employee(employeeID, employeeName, grossSalary);
}

    // Creates a Manager employee
    public Manager createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws InvalidArgumentException, CannotBeEmptyException{
        return new Manager(employeeID, employeeName, grossSalary, degree);
    }

    // Creates a Director employee
    public Director createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String department) throws InvalidArgumentException, CannotBeEmptyException{
        return new Director(employeeID, employeeName, grossSalary, degree, department);
    }

    // Creates an Intern employee
    public Intern createEmployee(String employeeID, String employeeName, double grossSalary, int GPA) throws EmployeeRegistryException, CannotBeEmptyException, InvalidArgumentException {
        return new Intern(employeeID, employeeName, grossSalary, GPA);
    }

}
