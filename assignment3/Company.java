package assignment3;

import java.util.HashMap;

import javax.management.openmbean.InvalidKeyException;

public class Company {

    HashMap<String, Employee> employees = new HashMap<String, Employee>();

    public Company() {
        // save
    }

    public double getNetSalary(String employeeID) {
        Employee e = employees.get(employeeID);
        return e.getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) {
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) {
        ManagerEmployee managerEmployee = new ManagerEmployee(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, managerEmployee);
        return "Employee " + employeeID + " was registered successfully.";
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

}