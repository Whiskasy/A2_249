package Employee;

import Exceptions.MinimumWageException;
import Deductions.*
        ;
public class Employee {
    //Employee class variables
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private double grossSalary;

    public Employee() {
    }
    // Parameterized Employee constructor
    public Employee(long employeeNumber, String firstName, String lastName, double hourlyWage, double hoursWorked, double grossSalary) throws MinimumWageException {

        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.grossSalary = calculateGrossSalary();
    }

    // Getters and setters for variables of Employee
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    // CalculateGrossSalary method with a getter
    public double calculateGrossSalary() {
        return (hoursWorked * hourlyWage * 52);
    }
    public double getGrossSalary(){
       return grossSalary;
    }
    // calculateDeductions method that makes a new instance of the different deductions classes and use their calculateTax() method
    public double calculateDeductions() {
        new EmploymentInsurance(this);
        new FederalTax(this);
        new ProvincialTax(this);
        new QPIP(this);
        new QPP(this);
        // Initialize totalDeductions variable and add and set equal to sum of the deductions
        double totalDeductions=0;
        totalDeductions += new EmploymentInsurance(this).calculateTax() +
                        new FederalTax(this).calculateTax()+
                        new ProvincialTax(this).calculateTax()+
                        new QPIP(this).calculateTax()+
                        new QPP(this).calculateTax();
        return totalDeductions;


        }
        // calculateNetSalary returns the grossSalary after deductions
    public double calculateNetSalary(){
        return grossSalary-calculateDeductions();
    }
}
