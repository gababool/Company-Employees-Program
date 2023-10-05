package assignment3;

public class Manager extends Employee {

    public String degree;
    
    public Manager(String ID, String name, double baseSalary, String degree) {
        super(ID, name, baseSalary);
        this.degree = degree;
        double salary = getSalaryBasedOnDegree(grossSalary, degree);
        this.setGrossSalary(salary);
    }

    private double getSalaryBasedOnDegree(double salary, String degree) {
        if (degree == "BSc") {
            return salary = baseSalary * 1.1;
        } else if (degree == "MSc") {
            return salary = baseSalary * 1.2;
        } else if (degree == "PhD") {
            return salary = baseSalary * 1.35;
        }
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, this.getGrossSalary());
    }

    public void setDegree(String degree) {
        this.degree = degree;
        getSalaryBasedOnDegree(baseSalary, degree);
    }

    public String getDegree(){
        return degree;
    }


    

}
