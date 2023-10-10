package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.management.openmbean.InvalidKeyException;

class SortByGrossSalary implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return Double.compare(a.grossSalary, b.grossSalary);
    }
}

//save


public class Company {

    HashMap<String, Employee> employees = new LinkedHashMap<String, Employee>();

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

    public String promotionSuccessMessage(String employeeID, String employeeType) {
        return employeeID + " promoted successfully to " + employeeType + ".";
    }

    // Creates regular employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws InvalidInputException {
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employees.put(employeeID, newEmployee);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates a Manager employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws InvalidInputException {
        Manager manager = new Manager(employeeID, employeeName, grossSalary, degree);
        employees.put(employeeID, manager);
       // if (degree == "") {
        //    throw new InvalidInputException("Employee " + employeeID + " CHANGE THIS.");
        //}
        return succefullRegistrationMessage(employeeID);
    }

    // Creates a Director employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String department) throws InvalidInputException {
        Director director = new Director(employeeID, employeeName, grossSalary, degree, department);
        employees.put(employeeID, director);
        return succefullRegistrationMessage(employeeID);
    }

    // Creates an Intern employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int GPA) throws InvalidInputException {
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
        for(Employee e : employees.values()){
            allEmployees += e + "\n";
        } 
        return allEmployees;
    }

    public String updateEmployeeName(String employeeID, String newName) throws InvalidInputException {
        Employee employee = employees.get(employeeID);
        employee.setName(newName);
        return updateSuccessMessage(employeeID);
    }

    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    public String updateGrossSalary(String employeeID, double salary) throws InvalidInputException {
        Employee employee = employees.get(employeeID);
        employee.setGrossSalary(salary);
        employee.baseSalary = employee.getGrossSalary();
        return updateSuccessMessage(employeeID);  
    }
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????
    // ??????????????????????????????????????????????????????

     public String updateManagerDegree(String employeeID, String newDegree) throws InvalidInputException {
        Manager employee = (Manager) employees.get(employeeID);
        employee.setDegree(newDegree);
        return updateSuccessMessage(employeeID);
    }

    public String updateInternGPA(String employeeID, int newGPA) {
        Intern employee = (Intern)employees.get(employeeID);
        employee.setGPA(newGPA);
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

    public void printDegree() {
        Map<String, Integer> degrees = this.mapEachDegree();
        System.out.println("Academic background of employees: ");
        for (String  d : degrees.keySet()){
            System.out.println(d + ": => " + degrees.get(d));
        }
    }

    public String printSortedEmployees() {
        String sortedByGrossSalary = "Employees sorted by gross salary (ascending order):\n";
        List<Employee> employees = new ArrayList<>(this.employees.values());

        Collections.sort(employees, new SortByGrossSalary());

        for(Employee employee : employees) {
            sortedByGrossSalary += employee + "\n";
        }

        return sortedByGrossSalary;
    }

    public String promoteToManager(String employeeID, String degree) throws InvalidInputException{
        Employee e = employees.remove(employeeID);
        employees.put(employeeID, new Manager(employeeID, e.getName(), e.getBaseSalary(), degree));
        return promotionSuccessMessage(employeeID, "Manager");
    }

    // For promotion without a previous degree
    public String promoteToDirector(String employeeID, String degree, String department) throws InvalidInputException{
        Employee e = employees.remove(employeeID);
        employees.put(employeeID, new Director(employeeID, e.getName(), e.getBaseSalary(), degree, department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    // For promotion where a previous degree exists
    public String promoteToDirector(String employeeID, String department) throws InvalidInputException{
        Manager e = (Manager)employees.remove(employeeID);
        employees.put(employeeID, new Director(employeeID, e.getName(), e.getBaseSalary(), e.getDegree(), department));
        return promotionSuccessMessage(employeeID, "Director");
    }

    public String promoteToIntern(String employeeID, int GPA) throws InvalidInputException{
        Employee e = employees.remove(employeeID);
        employees.put(employeeID, new Intern(employeeID, e.getName(), e.getBaseSalary(), GPA));
        return promotionSuccessMessage(employeeID, "Intern");
    }
}