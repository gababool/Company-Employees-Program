package assignment3;

public class Manager extends Employee {

    public String degree;

    public Manager(String ID, String name, double baseSalary, String degree) {
        super(ID, name, baseSalary);
        
        if (!(degree.equals("BSc") || degree.equals("MSc") || degree.equals("PhD"))) {
            throw new IllegalArgumentException("Degree must be one of the options: BSc, MSc or PhD.");
        }

        this.degree = degree;
        double salary = calculateSalary(baseSalary, degree);
        this.setGrossSalary(salary);
    }

    protected double calculateSalary(double salary, String degree) {
        if (degree == "BSc") {
            return salary * 1.1;
        } else if (degree == "MSc") {
            return salary * 1.2;
        } else if (degree == "PhD") {
            return salary * 1.35;
        } else {
            throw new InvalidDeptException("Degree must be one of the options: BSc, MSc or PhD.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, getGrossSalary());
    }

    public void setDegree(String degree) {
        this.degree = degree;
        this.grossSalary = calculateSalary(baseSalary, degree);
    }

    public String getDegree() {
        return degree;
    }

}
