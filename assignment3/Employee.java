package assignment3;

//import java.lang.Math;

public class Employee {

    private final String EMPLOYEE_ID;

    protected String name;
    protected double grossSalary;

    public Employee(String ID, String name, double salary){
        this.EMPLOYEE_ID = ID;
        this.name = name;
        this.grossSalary = truncateSalary(salary);
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

    public double truncateSalary(double salary){
        double truncatedSalary = (int)(salary * 1000.0) / 100;
        truncatedSalary = truncatedSalary / 10;
        return truncatedSalary;
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
        return truncateSalary(grossSalary - grossSalary * 0.1);
    }


    
    
    
}
