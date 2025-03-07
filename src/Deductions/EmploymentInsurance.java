package Deductions;
import Employee.Employee;

// Deductions class for the Employment Insurance with a rate of 1.64%
public class EmploymentInsurance extends Deductions {
private double eiRate = 0.0164;
private double eiMaxPremium = 1077.48;
private Employee employee;

    public EmploymentInsurance(Employee employee) {
        super(employee);
        this.employee = employee;
    }

// Calculate the tax amount for the Employment Insurance
    @Override
    public double calculateTax() {
        return Math.min(((employee.getGrossSalary()/100)*eiRate)*employee.getGrossSalary(), (eiMaxPremium));
    }
}
