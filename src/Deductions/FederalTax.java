package Deductions;
import Employee.Employee;

public class FederalTax extends Deductions {
private Employee employee;

    public FederalTax(Employee employee) {
        super(employee);
        this.employee = employee;
    }

    // Calculate the tax amount for the federal tax depending on the income of the employee
    @Override
    public double calculateTax() {
        double federalTax = 0;

    if (employee.getGrossSalary()<16129){
        federalTax = 0;
    } if (employee.getGrossSalary() >=16129 && employee.getGrossSalary() <=57375){
        federalTax = 0.15 * employee.getGrossSalary();
    } if (employee.getGrossSalary() >57376 && employee.getGrossSalary() <=114750){
        federalTax = 0.205 * employee.getGrossSalary();
    } if (employee.getGrossSalary() >114751 && employee.getGrossSalary() <=177882){
        federalTax = 0.26 * employee.getGrossSalary();
    } if (employee.getGrossSalary() >177883 && employee.getGrossSalary() <=253414){
        federalTax = 0.29 * employee.getGrossSalary();
    } if (employee.getGrossSalary() >253414){
        federalTax = .33 * employee.getGrossSalary();
    }
        return federalTax;
    }
}
