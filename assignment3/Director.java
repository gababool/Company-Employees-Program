package assignment3;

public class Director extends Manager {

    private String department;

    public Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department;
        this.grossSalary = this.grossSalary + 5000;
    }

    @Override
    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", this.degree, this.name, this.getGrossSalary(), this.department);
    }

    public double getNetSalary() {
        if(this.grossSalary > 50000) {
            double newGrossSalary = truncateSalary(grossSalary - (30000 * 0.2) - ((grossSalary - 30000) * 0.4));
            return newGrossSalary;
        } else if(this.grossSalary >= 30000) {
            return truncateSalary(grossSalary - grossSalary * 0.2);
        } else {
            return truncateSalary(grossSalary - grossSalary * 0.1);
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
