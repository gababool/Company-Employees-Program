package assignment3;

public class Manager extends Employee {

    public String degree;
    protected double initalGrossSalary;

    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
        this.initalGrossSalary = grossSalary;

        if (degree == "BSc") {
            this.grossSalary = grossSalary * 1.1;
        } else if (degree == "MSc") {
            this.grossSalary = grossSalary * 1.2;
        } else if (degree == "PhD") {
            this.grossSalary = grossSalary * 1.35;
        } else {
            this.grossSalary = grossSalary;
        }
    }

    @Override
    public String toString() {
        return degree + " " + name + "'s " + "gross salary is " + this.getGrossSalary() + " SEK per month.";
    }

}
