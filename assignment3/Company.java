package assignment3;

import java.util.HashMap;

<<<<<<< Updated upstream
=======
import javax.management.openmbean.InvalidKeyException;

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public String printEmployee(String employeeID) {
=======
    public class ManagerEmployee extends Employee {
        private String degree;

        public ManagerEmployee(String ID, String name, double grossSalary, String degree) {
            super(ID, name, grossSalary);
            this.degree = degree;

        }

        @Override
        public String toString() {
            return degree + " " + getName() + "'s " + "gross salary is " + getGrossSalary() + " SEK per month.";
        }

    }

    public String printEmployee(String employeeID) throws InvalidInputException {
>>>>>>> Stashed changes
        Employee e = employees.get(employeeID);
        if (e != null) {
            return e.toString();
        } else {
            throw new InvalidInputException("Employee " + employeeID + " was not registered yet.");
        }
    }

<<<<<<< Updated upstream
    public Employee getEmployee(String employeeID) {
        Employee e = employees.get(employeeID);
        return e;
    }

    public void removeEmployee(String employeeID) {
        employees.remove(employeeID);
=======
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
>>>>>>> Stashed changes
    }

}