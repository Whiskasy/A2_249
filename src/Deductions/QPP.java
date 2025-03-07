package Deductions;
import Employee.Employee;

public class QPP extends Deductions{
    double qppRate= 0.108;
    double qppMaxPremium = 7700.40;
    private Employee employee;

    public QPP(Employee employee) {
        super(employee);
        this.employee = employee;
    }
    // Calculate the tax amount for the QPP
    @Override
    public double calculateTax() {
        return Math.min((qppRate*employee.getGrossSalary()), (qppMaxPremium));
    }
}
