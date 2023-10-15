package assignment3;

public class Intern extends Employee {

    private int GPA;
    private double internBonus = 1000.0;

    public Intern(String ID, String name, double baseSalary, int GPA) throws Exception {
        super(ID, name, baseSalary);
        
        if (0 > GPA || GPA > 10) {
            throw new InvalidInputException(GPA + " outside range. Must be between 0-10.");
        }

        this.GPA = GPA;
        calculateInternSalary(this.GPA, this.baseSalary);
    }

    public void setGPA(int GPA) throws Exception {
        if (0 > GPA || GPA > 10) {
            throw new InvalidInputException(GPA + " outside range. Must be between 0-10.");
        }
        this.GPA = GPA;
    }

    private double calculateInternSalary(int GPA, double salary) {
        if (this.GPA <= 5) {
            salary = 0.0;
        } else if (GPA >= 8) {
            salary = baseSalary + internBonus;
        }
        return salary;
    }

    public double getGrossSalary(){
        double grossSalary = calculateInternSalary(GPA, baseSalary);
        return truncateSalary(grossSalary);
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %d", name, this.getGrossSalary(), GPA);
    }

    public double getNetSalary() {
        return this.grossSalary;
    }
}
