package assignment3;

public class Intern extends Employee {

    private int GPA;

    public Intern(String ID, String name, double baseSalary, int GPA) throws InvalidInputException {
        super(ID, name, baseSalary);
        if (0 > GPA || GPA > 10){
            throw new InvalidInputException(GPA + " outside range. Must be between 0-10.");
        }
        this.GPA = GPA;
        setGrossSalaryBasedOnGPA(this.GPA, this.baseSalary);
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
        setGrossSalaryBasedOnGPA(GPA, baseSalary);
    }
   
     private void setGrossSalaryBasedOnGPA(int GPA, double baseSalary) {
        if(this.GPA <= 5) {
            this.grossSalary = 0.0;
        } else if(GPA >= 8) {
            this.grossSalary = baseSalary + 1000.0;
        }
    }

    @Override
    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %d", name, this.getGrossSalary(), GPA);
    }

    public double getNetSalary() {
        return this.grossSalary;
    }
}
