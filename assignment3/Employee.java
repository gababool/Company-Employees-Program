package assignment3;

public class Employee {

    private final String EMPLOYEE_ID;

    private String name;
    private double grossSalary;
    private double netSalary;

    public Employee(String ID, String name, double salary){
        this.EMPLOYEE_ID = ID;
        this.name = name;
        this.grossSalary = truncateSalary(salary);
        this.netSalary = truncateSalary(grossSalary - (grossSalary * 0.1));
    }

    @Override
    public String toString(){
        return String.format("%s's gross salary is %d SEK per month", name, grossSalary);
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
        double truncatedSalary = (double)Math.round(salary*100)/100;
        return truncatedSalary;
    }

    public String getname() {
        return name;
    }

    public String getEmployeeID() {
        return EMPLOYEE_ID;
    }

    public double getgrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }


    
    
    
}
