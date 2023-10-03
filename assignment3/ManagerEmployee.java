package assignment3;

public class ManagerEmployee extends Employee {
        private String degree;

        public ManagerEmployee(String ID, String name, double grossSalary, String degree) {
            super(ID, name, grossSalary);
            this.degree = degree;

        }

        @Override
        public String toString() {
            return degree + " " + name + "'s " + "gross salary is " + grossSalary + " SEK per month.";
        }

    }
