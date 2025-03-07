package Deductions;

import Employee.Employee;

public class ProvincialTax extends Deductions{
private Employee employee;

    public ProvincialTax(Employee employee) {
        super(employee);
        this.employee = employee;
    }

    // Calculate the tax amount for the provincial tax depending on the income of the employee
    @Override
    public double calculateTax() {
            double provincialTax = 0;
        if (employee.getGrossSalary() <= 18571){
            provincialTax = 0;
        } if (employee.getGrossSalary() > 18571 && employee.getGrossSalary() <= 53255){
            provincialTax = 0.14 * employee.getGrossSalary();
        } if (employee.getGrossSalary() > 52355 && employee.getGrossSalary() <= 106495){
            provincialTax = 0.19 * employee.getGrossSalary();
        } if (employee.getGrossSalary() > 106495 && employee.getGrossSalary() <= 129590){
            provincialTax = 0.24 * employee.getGrossSalary();
        } if (employee.getGrossSalary() > 129590){
            provincialTax = 0.2575 * employee.getGrossSalary();
        }
        return provincialTax;
    }
}
