package assignment3;

public class Employee {

    private final String EMPLOYEE_ID;

    protected String name;
    protected double baseSalary;
    protected double grossSalary;

    public Employee(String ID, String name, double baseSalary) throws Exception {

        if (ID.trim() == ""){
            throw new EmptyArgumentException("ID cannot be blank.");
        }
        if (name.trim() == ""){
            throw new EmptyArgumentException("Name cannot be blank.");
        }
        if (baseSalary < 0){
            throw new InvalidInputException("Salary must be greater than zero.");
        }

        this.EMPLOYEE_ID = ID;
        this.name = name;
        this.baseSalary = baseSalary;
        setGrossSalary(baseSalary);
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, grossSalary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null || !(obj instanceof Employee)) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return EMPLOYEE_ID == otherEmployee.getEmployeeID();
    }

    public static double truncateSalary(double salary) {
        return (int)(salary * 100) / 100.0;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return EMPLOYEE_ID;
    }

    public double getGrossSalary() {
        return truncateSalary(grossSalary);
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public double getNetSalary() {
        grossSalary = getGrossSalary();
        return truncateSalary(grossSalary - grossSalary * 0.1);
    }

    public void setName(String name) throws Exception {
        if (name.trim() == ""){
            throw new EmptyArgumentException("Name cannot be blank.");
        }
        this.name = name;
    }

    public void setBaseSalary(double salaryAmount) throws Exception {
        if (salaryAmount <= 0){
            throw new InvalidInputException("Salary must be greater than zero.");
        }
        this.baseSalary = truncateSalary(salaryAmount);
    }

    public void setGrossSalary(double salaryAmount) throws Exception {
        if (salaryAmount <= 0){
            throw new InvalidInputException("Salary must be greater than zero.");
        }
        this.grossSalary = truncateSalary(salaryAmount);
    }

}
