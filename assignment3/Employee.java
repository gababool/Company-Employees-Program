package assignment3;
import java.lang.Math;

public class Employee {

    private final String EMPLOYEE_ID;

    protected String name;
    protected double baseSalary;
    protected double grossSalary;

    public Employee(String ID, String name, double baseSalary) throws InvalidInputException {
        if (ID == ""){
            throw new InvalidInputException("ID cannot be blank.");
        }
        if (name == ""){
            throw new InvalidInputException("Name cannot be blank.");
        }
        if (baseSalary < 0){
            throw new InvalidInputException("Salary must be greater than zero.");
        }

        this.EMPLOYEE_ID = ID;
        this.name = name;
        setBaseSalary(baseSalary); // What is the purpose of this method? Same as gross?
        setGrossSalary(baseSalary);
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, this.getGrossSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null || !(obj instanceof Employee)) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.EMPLOYEE_ID == otherEmployee.getEmployeeID();
    }

    public static double truncateSalary(double salary) {
        return (int)(salary * 100) / 100.0;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return EMPLOYEE_ID;
    }

    public double getGrossSalary() {
        return truncateSalary(this.grossSalary);
    }

    public double getNetSalary() {
        grossSalary = this.getGrossSalary();
        return truncateSalary(grossSalary - grossSalary * 0.1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = truncateSalary(grossSalary);
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = truncateSalary(baseSalary);
    }
}
