package Deductions;
import Employee.Employee;
public class QPP extends Deductions{

    private Employee employee;
    public QPP(Employee employee){
        this.employee = employee;
    }

    @Override
    public double calculateTax() {
        return 0.108* employee.getEmployeeGrossSalary();
    }
}
