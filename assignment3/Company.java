package assignment3;

import java.util.HashMap;

public class Company {

    HashMap<String, Employee> employees = new HashMap<String, Employee>();

    public Company() {
        // save
    }

    public double getNetSalary(String employeeID) {
        Employee e = employees.get(employeeID);
        return e.getNetSalary();
    }

    private String succefullRegistrationMessage(String employeeID) {
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String updateSuccessMessage(String employeeID){
        return "Employee " + employeeID + " was updated successfully";
    }

    // Creates regular employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary) {
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates a Manager employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree){
        Manager manager = new Manager(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, manager);
        return succefullRegistrationMessage(employeeID);     
    }

    // Creates a Director employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String department) {
        Director director = new Director(employeeID, employeeName, grossSalary, degree, department);
        employees.put(employeeID, director);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates and Intern employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa){
        Intern intern = new Intern(employeeID, employeeName, grossSalary, gpa);
        employees.put(employeeID, intern);
        return succefullRegistrationMessage(employeeID);
    }

    public String printEmployee(String employeeID) throws InvalidInputException {
        Employee e = employees.get(employeeID);
        if (e != null) {
            return e.toString();
        } else {
            throw new InvalidInputException("Employee " + employeeID + " was not registered yet.");
        }
    }

    public Employee getEmployee(String employeeID) {
        Employee e = employees.get(employeeID);
        return e;
    }

    public String removeEmployee(String employeeID) throws InvalidInputException {
        Employee e = employees.get(employeeID);
        if (e != null) {
            employees.remove(employeeID);
            return "Employee " + employeeID + " was successfully removed.";
        }
        throw new InvalidInputException("Employee " + employeeID + " was not registered yet.");
        // &throw new InvalidKeyException
    }

    public double getTotalNetSalary(){
        double totalSalary = 0;
        for(Employee e : employees.values()){
            totalSalary += e.getNetSalary();
        } 
        return Employee.truncateSalary(totalSalary);
    }

    public String printAllEmployees(){
        String allEmployees = "";
        int employeeCount = 0;
        for(Employee e : employees.values()){
            allEmployees += e;
            employeeCount ++;
        } 
        if (employeeCount < employees.size()){
            allEmployees += "\n";
        }
        return allEmployees;
    }

    public String updateEmployeeName(String employeeID, String newName){
        Employee employee = employees.get(employeeID);
        employee.setName(newName);
        return updateSuccessMessage(employeeID);
    }

    public String updateGrossSalary(String employeeID, double newGrossSalary){
        Employee employee = employees.get(employeeID);
        employee.setGrossSalary(newGrossSalary);
        return updateSuccessMessage(employeeID);
    }

    public String updateInternGPA(String employeeID, int newGPA) {

        // CODE HERE ONCE INTERN CLASS IS DONE

        return updateSuccessMessage(employeeID);
    }

    public String updateManagerDegree(String employeeID, String newDegree) {
        Manager employee = (Manager)employees.get(employeeID);
        employee.setDegree(newDegree);
        return updateSuccessMessage(employeeID);
    }

    public String updateDirectorDept(String employeeID, String newDept) {
        Director employee = (Director)employees.get(employeeID);
        employee.setDepartment(newDept);
        return updateSuccessMessage(employeeID);
    }

}