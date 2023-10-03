package assignment3;

import java.util.HashMap;

public class Company{

    HashMap<String, Employee> employees = new HashMap<String, Employee>();

    public Company() {

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

    public String printEmployee(String employeeID) {
        Employee e = employees.get(employeeID);
        if (e != null) {
            return e.toString();
        } else {
            return "Employee not found";
        }
    }

    public Employee getEmployee(String employeeID) {
        Employee e = employees.get(employeeID);
        return e;
    }

    public void removeEmployee(String employeeID) {
        employees.remove(employeeID);
    }

}