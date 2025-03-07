package Deductions;
import Employee.Employee;
public abstract class Deductions {
    protected double grossSalary;

    public Deductions() {
    }

    public Deductions(Employee employee) {
        this.grossSalary = employee.getGrossSalary();
    }
    abstract public double calculateTax();
}
