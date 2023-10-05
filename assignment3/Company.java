package assignment3;

import java.util.HashMap;
import java.util.Map;
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

    private String succefullRegistrationMessage(String employeeID) {
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String updateSuccessMessage(String employeeID) {
        return "Employee " + employeeID + " was updated successfully";
    }

    // Creates regular employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary) {
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates a Manager employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) {
        Manager manager = new Manager(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, manager);
       // if (degree == "") {
        //    throw new InvalidInputException("Employee " + employeeID + " CHANGE THIS.");
        //}
        return succefullRegistrationMessage(employeeID);
    }

    // Creates a Director employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String department) {
        Director director = new Director(employeeID, employeeName, grossSalary, degree, department);
        employees.put(employeeID, director);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates and Intern employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int GPA) {
            Intern intern = new Intern(employeeID, employeeName, grossSalary, GPA);
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

    public double getTotalNetSalary() {
        double totalSalary = 0;
        for (Employee e : employees.values()) {
            totalSalary += e.getNetSalary();
        }
        return Employee.truncateSalary(totalSalary);
    }
   
    public String printAllEmployees(){
        String allEmployees = "All registered employees:\n";
        int employeeCount = 0;
        for(Employee e : this.employees.values()){
            allEmployees += e;
            employeeCount ++;

            if (employeeCount < this.employees.size()){
                allEmployees += "\n";
            }
        } 
        return allEmployees;
    }

    public String updateEmployeeName(String employeeID, String newName) {
        Employee employee = employees.get(employeeID);
        employee.setName(newName);
        return updateSuccessMessage(employeeID);
    }

    public String updateGrossSalary(String employeeID, double newGrossSalary) {
        Employee employee = employees.get(employeeID);
        employee.setGrossSalary(newGrossSalary);
        return updateSuccessMessage(employeeID);
    }

    public String updateInternGPA(String employeeID, int newGPA) {
         return updateSuccessMessage(employeeID);
    }

    public String updateManagerDegree(String employeeID, String newDegree) {
        Manager employee = (Manager) employees.get(employeeID);
        employee.setDegree(newDegree);
        return updateSuccessMessage(employeeID);
    }

    public String updateDirectorDept(String employeeID, String newDept) {
        Director employee = (Director) employees.get(employeeID);
        employee.setDepartment(newDept);
        return updateSuccessMessage(employeeID);
    }

    public Map<String, Integer> mapEachDegree() {
        HashMap<String, Integer> numOfDegree = new HashMap<String, Integer>();
        for (Employee e : employees.values()) {
            if (e instanceof Manager) {
                Manager manager = (Manager) e;
                String degree = manager.getDegree();
                Integer count = numOfDegree.get(degree);
                if (count == null) {
                    numOfDegree.put(degree, 1);
                } else {
                    numOfDegree.put(degree, ++count);
                }
            }
        }
        return numOfDegree;
    }

    public void printDegree(){
        Map<String, Integer> degrees = this.mapEachDegree();
        System.out.println("Academic background of employees: ");
        for (String  d : degrees.keySet()){
            System.out.println(d + ": => " + degrees.get(d));
        }
    }

}