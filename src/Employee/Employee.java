package Employee;

import Exceptions.MinimumWageException;

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
        if (hourlyWage < 15.75){
            throw new MinimumWageException("Hourly wage must be greater than 15.75");
        }
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


    /*Must See if need to implement
    public String toString() {
        return "Employee Number: " + employeeNumber + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGross salary: " + grossSalary; + "\nDeductions";
    }
    */
}
