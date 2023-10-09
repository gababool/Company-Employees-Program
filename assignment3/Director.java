package assignment3;

public class Director extends Manager {

    private final int DIRECTOR_BONUS = 5000;
    private String department;

    public Director(String ID, String name, double baseSalary, String degree, String department) throws InvalidInputException {
        super(ID, name, baseSalary, degree);
        this.department = department;
        double salaryWithBonus = getSalaryWithBonus(this.grossSalary);
        this.setGrossSalary(salaryWithBonus);
    }

    @Override
    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", 
        this.degree, this.name, this.getGrossSalary(), this.department);
    }

    public double getNetSalary() {
        if(this.grossSalary > 50000) {
            return this.grossSalary - (30000 * 0.2) - ((this.grossSalary - 30000) * 0.4);
            //return truncateSalary(this.grossSalary - (30000 * 0.2) - ((this.grossSalary - 30000) * 0.4));
        } else if(this.grossSalary >= 30000) {
            return (this.grossSalary - this.grossSalary * 0.2);
            // return truncateSalary(this.grossSalary - this.grossSalary * 0.2);
        } else {
            return this.grossSalary - this.grossSalary * 0.1;
            // return truncateSalary(this.grossSalary - this.grossSalary * 0.1);
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalaryWithBonus(double salary){
        return salary + DIRECTOR_BONUS;
    }
    
}
