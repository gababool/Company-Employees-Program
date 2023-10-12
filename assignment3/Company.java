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

    private HashMap<String, Employee> employees = new LinkedHashMap<String, Employee>();

    public Company() {}

    public double getNetSalary(String employeeID) throws Exception {
        Employee e = employees.get(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        return e.getNetSalary();
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
            throws Exception {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Employee newEmployee = EmployeeFactory.createEmployee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates a Manager employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree)
            throws Exception {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Employee manager = EmployeeFactory.createManager(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, manager);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates a Director employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree,
            String department) throws Exception {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Director director = EmployeeFactory.createDirector(employeeID, employeeName, grossSalary, degree, department);
        employees.put(employeeID, director);
        return successfullRegistrationMessage(employeeID);
    }

    // Creates an Intern employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int GPA)
            throws Exception {
        if (employees.containsKey(employeeID)) {
            throw new InvalidInputException("Cannot register. ID " + employeeID + " is already registered.");
        }
        Intern intern = EmployeeFactory.createIntern(employeeID, employeeName, grossSalary, GPA);
        employees.put(employeeID, intern);
        return successfullRegistrationMessage(employeeID);
    }

    public String printEmployee(String employeeID) throws Exception {
        Employee e = employees.get(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        return e.toString();
    }

    public Employee getEmployee(String employeeID) throws Exception {
        Employee e = employees.get(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        return e;
    }

    public String removeEmployee(String employeeID) throws Exception {
        Employee e = employees.get(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employees.remove(employeeID);
        return "Employee " + employeeID + " was successfully removed.";

    }

    public double getTotalNetSalary() throws Exception {
        if (employees.isEmpty()) {
            throw new NullValueException("No employees registered yet.");
        }
        double totalSalary = 0;
        for (Employee e : employees.values()) {
            totalSalary += e.getNetSalary();
        }
        return Employee.truncateSalary(totalSalary);
    }

    public String printAllEmployees() throws Exception {
        if (employees.isEmpty()) {
            throw new NullValueException("No employees registered yet.");
        }
        String allEmployees = "All registered employees:\n";
        for (Employee e : employees.values()) {
            allEmployees += e + "\n";
        }
        return allEmployees;
    }

    public String updateEmployeeName(String employeeID, String newName) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setName(newName);
        return updateSuccessMessage(employeeID);
    }

    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    public String updateGrossSalary(String employeeID, double salary) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setGrossSalary(salary);
        employee.baseSalary = employee.getGrossSalary();
        return updateSuccessMessage(employeeID);
    }
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????

    public String updateManagerDegree(String employeeID, String newDegree) throws Exception {
        Manager employee = (Manager) employees.get(employeeID);
        if (employee == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setDegree(newDegree);
        return updateSuccessMessage(employeeID);
    }

    public String updateInternGPA(String employeeID, int newGPA) throws Exception {
        Intern employee = (Intern) employees.get(employeeID);
        if (employee == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setGPA(newGPA);
        return updateSuccessMessage(employeeID);
    }

    public String updateDirectorDept(String employeeID, String newDept) throws Exception {
        Director employee = (Director) employees.get(employeeID);
        if (employee == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employee.setDepartment(newDept);
        return updateSuccessMessage(employeeID);
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        HashMap<String, Integer> numOfDegree = new HashMap<String, Integer>();
        if (employees.isEmpty()) {
            throw new NullValueException("No employees registered yet.");
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

    public void printDegree() throws Exception {
        Map<String, Integer> degrees = this.mapEachDegree();
        System.out.println("Academic background of employees: ");
        for (String d : degrees.keySet()) {
            System.out.println(d + ": => " + degrees.get(d));
        }
    }

    public String printSortedEmployees() throws Exception {
        if (employees.isEmpty()) {
            throw new NullValueException("No employees registered yet.");
        }
        String sortedByGrossSalary = "Employees sorted by gross salary (ascending order):\n";
        List<Employee> employees = new ArrayList<>(this.employees.values());

        Collections.sort(employees, new SortByGrossSalary());

        for (Employee employee : employees) {
            sortedByGrossSalary += employee + "\n";
        }
        return sortedByGrossSalary;
    }

    public String promoteToManager(String employeeID, String degree) throws Exception  {
        Employee e = employees.remove(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, EmployeeFactory.createManager(employeeID, e.getName(), e.getBaseSalary(), degree));
        return promotionSuccessMessage(employeeID, "Manager");
    }

    // For promotion where employee is lacking a previous degree
    public String promoteToDirector(String employeeID, String degree, String department) throws Exception{
        Employee e = employees.remove(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, EmployeeFactory.createDirector(employeeID, e.getName(), e.getBaseSalary(), degree, department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    // For promotion where a previous degree exists, i.e the employee is already a Manager
    public String promoteToDirector(String employeeID, String department) throws Exception {
        Manager e = (Manager) employees.remove(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, EmployeeFactory.createDirector(employeeID, e.getName(), e.getBaseSalary(), e.getDegree(), department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    public String promoteToIntern(String employeeID, int GPA) throws Exception {
        Employee e = employees.remove(employeeID);
        if (e == null) {
            throw new NullValueException("Employee " + employeeID + " was not registered yet.");
        }
        employees.put(employeeID, EmployeeFactory.createIntern(employeeID, e.getName(), e.getBaseSalary(), GPA));
        return promotionSuccessMessage(employeeID, "Intern");
    }
}