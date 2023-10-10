package assignment3;

public class Manager extends Employee {

    public String degree;
    
    public Manager(String ID, String name, double baseSalary, String degree) throws InvalidInputException {
        super(ID, name, baseSalary);
        this.degree = degree;
        double salary = calculateSalary(baseSalary, degree);
        this.setGrossSalary(salary);
    }

    protected double calculateSalary(double salary, String degree) throws InvalidInputException {
        if (degree == "BSc") {
            return baseSalary * 1.1;
        } else if (degree == "MSc") {
            return baseSalary * 1.2;
        } else if (degree == "PhD") {
            return baseSalary * 1.35;  
        } else {
            throw new InvalidInputException("Degree must be one of the options: BSc, MSc or PhD.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, this.getGrossSalary());
    }

    public void setDegree(String degree) throws InvalidInputException {
        this.degree = degree;
        this.grossSalary = calculateSalary(baseSalary, degree);
    }

    public String getDegree(){
        return degree;
    }


    

}
