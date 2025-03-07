package Deductions;
import Employee.Employee;

public class QPIP extends Deductions {
    double qpipRate= 0.00494;
    double qpipMaxPremium = 494.12;
    private Employee employee;

    public QPIP(Employee employee) {
        super(employee);
        this.employee = employee;
    }
    // Calculate the tax amount for the QPIP
    @Override
    public double calculateTax() {
        return Math.min((qpipRate*employee.getGrossSalary()), (qpipMaxPremium));
    }
}
