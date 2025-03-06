package Employee;

public class Employee {

    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private Employee[] employee;

    public Employee() {}

    public double getHourlyWage() {
        return hourlyWage;
    }
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public double getEmployeeGrossSalary(){

        return hoursWorked*hourlyWage*52;
    }
}
