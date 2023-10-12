package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class SortByGrossSalary implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return Double.compare(a.grossSalary, b.grossSalary);
    }
}

public class Company {

    HashMap<String, Employee> employees = new LinkedHashMap<String, Employee>();

    public Company() {}

    public double getNetSalary(String employeeID) throws NullPointerException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }  
        return employee.getNetSalary();    
    }

    private String successfullRegistrationMessage(String employeeID) {
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String updateSuccessMessage(String employeeID) {
        return "Employee " + employeeID + " was updated successfully";
    }

    public String promotionSuccessMessage(String employeeID, String employeeType) {
        return employeeID + " promoted successfully to " + employeeType + ".";
    }

    // Creates regular employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary)
            throws InvalidInputException {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates a Manager employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree)
            throws InvalidInputException {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Manager manager = new Manager(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, manager);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates a Director employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree,
            String department) throws InvalidInputException {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Director director = new Director(employeeID, employeeName, grossSalary, degree, department);
        employees.put(employeeID, director);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates an Intern employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int GPA)
            throws InvalidInputException {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Intern intern = new Intern(employeeID, employeeName, grossSalary, GPA);
        employees.put(employeeID, intern);
        return successfullRegistrationMessage(employeeID);
    }

    public String printEmployee(String employeeID) throws NullPointerException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        return employee.toString();
    }

    public Employee getEmployee(String employeeID) throws NullPointerException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        return employee;
    }

    public String removeEmployee(String employeeID) throws NullPointerException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employees.remove(employeeID);
        return "Employee " + employeeID + " was successfully removed.";
        
    }

    public double getTotalNetSalary() throws NullPointerException {
        if (employees.isEmpty()) {
            throw new NullPointerException("No employees registered yet.");
        }
        double totalSalary = 0;
        for (Employee employee : employees.values()) {
            totalSalary += employee.getNetSalary();
        }
        return Employee.truncateSalary(totalSalary);
    }

    public String printAllEmployees() throws NullPointerException {
        if (employees.isEmpty()) {
            throw new NullPointerException("No employees registered yet.");
        }
        String allEmployees = "All registered employees:\n";
        for (Employee employee : employees.values()) {
            allEmployees += employee + "\n";
        }
        return allEmployees;
    }

    public String updateEmployeeName(String employeeID, String newName)
            throws NullPointerException, InvalidInputException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setName(newName);
        return updateSuccessMessage(employeeID);
    }

    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    public String updateGrossSalary(String employeeID, double salary)
            throws InvalidInputException, NullPointerException {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setGrossSalary(salary);
        employee.baseSalary = employee.getGrossSalary();
        return updateSuccessMessage(employeeID);
    }
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????

    public String updateManagerDegree(String employeeID, String newDegree) throws InvalidInputException, NullPointerException {
        Manager employee = (Manager) employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setDegree(newDegree);
        return updateSuccessMessage(employeeID);
    }

    public String updateInternGPA(String employeeID, int newGPA) throws NullPointerException, InvalidInputException{
        Intern employee = (Intern) employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setGPA(newGPA);
        return updateSuccessMessage(employeeID);
    }

    public String updateDirectorDept(String employeeID, String newDept) throws NullPointerException, InvalidInputException{
        Director employee = (Director) employees.get(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setDepartment(newDept);
        return updateSuccessMessage(employeeID);
    }

    public Map<String, Integer> mapEachDegree() throws NullPointerException {
        HashMap<String, Integer> numOfDegree = new HashMap<String, Integer>();
        if (employees.isEmpty()) {
            throw new NullPointerException("No employees registered yet.");
        }
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

    public void printDegree() {
        Map<String, Integer> degrees = this.mapEachDegree();
        System.out.println("Academic background of employees: ");
        for (String degree : degrees.keySet()) {
            System.out.println(degree + ": => " + degrees.get(degree));
        }
    }

    public String printSortedEmployees() throws NullPointerException {
        if (employees.isEmpty()) {
            throw new NullPointerException("No employees registered yet.");
        }
        String sortedByGrossSalary = "Employees sorted by gross salary (ascending order):\n";
        List<Employee> employees = new ArrayList<>(this.employees.values());

        Collections.sort(employees, new SortByGrossSalary());

        for (Employee employee : employees) {
            sortedByGrossSalary += employee + "\n";
        }
        return sortedByGrossSalary;
    }

    public String promoteToManager(String employeeID, String degree)
            throws NullPointerException, InvalidInputException {
        Employee employee = employees.remove(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, new Manager(employeeID, employee.getName(), employee.getBaseSalary(), degree));
        return promotionSuccessMessage(employeeID, "Manager");
    }

    // For promotion where employee is lacking a previous degree
    public String promoteToDirector(String employeeID, String degree, String department)
            throws NullPointerException, InvalidInputException {
        Employee employee = employees.remove(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, new Director(employeeID, employee.getName(), employee.getBaseSalary(), degree, department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    // For promotion where a previous degree exists, i.e the employee is already a Manager
    public String promoteToDirector(String employeeID, String department)
            throws NullPointerException, InvalidInputException {
        Manager employee = (Manager) employees.remove(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, new Director(employeeID, employee.getName(), employee.getBaseSalary(), employee.getDegree(), department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    public String promoteToIntern(String employeeID, int GPA) throws NullPointerException, InvalidInputException {
        Employee employee = employees.remove(employeeID);
        if (employee == null) {
            throw new NullPointerException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, new Intern(employeeID, employee.getName(), employee.getBaseSalary(), GPA));
        return promotionSuccessMessage(employeeID, "Intern");
    }
}