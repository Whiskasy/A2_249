package Deductions;
import Employee.Employee;
public abstract class Deductions {
    protected double grossSalary;

    public Deductions() {
    }

    public Deductions(Employee employee) {
        this.grossSalary = employee.getGrossSalary();
    }
    //Abstract calculate tax method all subclasses will have to implement
    abstract public double calculateTax();
}
