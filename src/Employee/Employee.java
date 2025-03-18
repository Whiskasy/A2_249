package Employee;

import Exceptions.MinimumWageException;
import Deductions.*
        ;
public class Employee {

    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private double grossSalary;
//    private Employee[] employee;

    public Employee() {
    }

    public Employee(long employeeNumber, String firstName, String lastName, double hourlyWage, double hoursWorked, double grossSalary) throws MinimumWageException {

        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.grossSalary = calculateGrossSalary();
    }

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

    public double calculateGrossSalary() {
        return (hoursWorked * hourlyWage * 52);
    }
    public double getGrossSalary(){
       return grossSalary;
    }

    public double calculateDeductions() {
        new EmploymentInsurance(this);
        new FederalTax(this);
        new ProvincialTax(this);
        new QPIP(this);
        new QPP(this);

        double totalDeductions=0;
        totalDeductions += new EmploymentInsurance(this).calculateTax() +
                        new FederalTax(this).calculateTax()+
                        new ProvincialTax(this).calculateTax()+
                        new QPIP(this).calculateTax()+
                        new QPP(this).calculateTax();
        return totalDeductions;


        }
    public double calculateNetSalary(){
        return grossSalary-calculateDeductions();
    }
}
