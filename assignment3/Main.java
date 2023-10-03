package assignment3;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("123", "Martin", 1000.126723434);
        System.out.println(employee.getgrossSalary());
        System.out.println(employee.getNetSalary());
    }
}
