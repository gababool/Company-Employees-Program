package assignment3;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Employee {
    
    private static final String EOL = System.lineSeparator();
    private final String ID;
    private String name;
    private double grossSalary;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return truncateSalary(grossSalary);
    }

    public double truncateSalary(double salary) {
        return Math.floor(salary * 100) / 100;
    }

    public double getNetSalary() {
        double netSalary = getGrossSalary() - getGrossSalary() * 0.1;
        return truncateSalary(netSalary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Employee)) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        boolean sameID = ID == otherEmployee.getID();
        return sameID;
    }

    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.00"); 
        return name + "'s" + " gross salary is " + formatter.format(truncateSalary(getGrossSalary())) + " SEK per month.";
    }
}
