package assignment3;

import java.lang.Math;

public class Employee {

    private final String EMPLOYEE_ID;

    protected String name;
    protected double baseSalary;
    protected double grossSalary;

    public Employee(String ID, String name, double baseSalary){
        this.EMPLOYEE_ID = ID;
        this.name = name;
        setBaseSalary(baseSalary);
        setGrossSalary(baseSalary);
    }

    @Override
    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month.", name, this.getGrossSalary());
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        else if (obj != null || !(obj instanceof Employee)){
            return false;
        }
        Employee otherEmployee = (Employee)obj;
        return this.EMPLOYEE_ID == otherEmployee.getEmployeeID();
    }

    public static double truncateSalary(double salary){
        return Math.floor(salary * 100) / 100;
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

    public int compareTo(Employee otherEmployee) {
        return Double.compare(this.grossSalary, otherEmployee.grossSalary);

    }
    
}
