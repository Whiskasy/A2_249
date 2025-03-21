package Driver;
import java.io.*;
import Exceptions.MinimumWageException;
import Employee.Employee;

//-----------------------------------------------------------
// Assignment 2
// Written by: Gabriel Lippé (40316342)
// General explanation: This program reads a payroll file and processes it
// to calculate the net salary, tax deductions and the yearly gross salary.
// It then generates a report file with an employee's information in a
// tabular format.
//-----------------------------------------------------------

public class Driver {
    private static Employee[] employees = new Employee[100];
    private static int employeeCount = 0;


        public static void main(String[] args) {
            System.out.println("Welcome to the payroll file processor program by Gabriel Lippé.");
            //Use functions to read and write
            readPayrollFile("src/Driver/payroll.txt");
            writeReport("src/Driver/payrollReport.txt");
        }

        //Read payroll.txt method
        private static void readPayrollFile(String fileName) {
            System.out.println("> Opening file payroll... ");
            System.out.println("> Reading file payroll...");
            System.out.println("> Error lines found in file Payroll:");
            int lineCount=0;
            int errorLineCount=0;
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
                BufferedWriter errorWriter = new BufferedWriter(new FileWriter("src/Driver/payrollError.txt"))) {
                String line;

                while ((line = reader.readLine()) != null && employeeCount < 100) {
                    try {
                        String[] parts = line.split(" ");
                        if (parts.length != 5) {
                            throw new IllegalArgumentException("Invalid number of fields in: " + line);
                        }

                        // Assign what is read from the lines and parse them to the correct variable
                        long employeeNumber = Long.parseLong(parts[0]);
                        String firstName = parts[1];
                        String lastName = parts[2];
                        double hoursWorked = Double.parseDouble(parts[3]);
                        double hourlyWage = Double.parseDouble(parts[4]);
                        double grossSalary = hourlyWage * hoursWorked * 52;

                        if (hourlyWage < 15.75) {
                            throw new MinimumWageException("Below minimum wage: " +line);

                        }

                        // Create a new employee object
                        Employee emp = new Employee(employeeNumber, firstName, lastName, hourlyWage, hoursWorked, grossSalary);
                        employees[employeeCount++] = emp;

                    } catch (MinimumWageException e) {
                        System.out.println(line);
                        errorWriter.write(e.getMessage());
                        errorWriter.newLine();
                        errorLineCount++;
                    }
                    // Write the invalid record to payrollError.txt
                    catch (Exception e) {
                        System.out.println(line);
                        errorWriter.write("Error: " + line);
                        errorWriter.newLine();
                        errorLineCount++;
                    }
                    lineCount++;
                }
            }catch (IOException e){
                System.out.println("IO exception reading payroll file");
            }
            System.out.println("> "+ lineCount + " lines read from file payroll");
            System.out.println("> " + errorLineCount + " lines written to error file");
            System.out.println("> Calculating deductions");
            System.out.println("> Writing report file");
        }

        //WriteReport method
        private static void writeReport(String fileName) {
            BufferedWriter reportWriter = null;
            try {  reportWriter = new BufferedWriter(new FileWriter(fileName));
                reportWriter.write("                        iDroid Solutions\n"
                                    + "                     -----------------------\n");
                reportWriter.write("Employee Number   First Name   Last Name   Gross Salary   Deductions   Net Salary\n");
                reportWriter.write("---------------------------------------------------------------------------------\n");

                for (int i=0; i<employeeCount; i++){
                Employee emp = employees[i];
                reportWriter.write(String.format("%-15d %-15s %-15s %-12.2f %-10.2f %-10.2f\n", emp.getEmployeeNumber(), emp.getFirstName(), emp.getLastName(),
                        emp.getGrossSalary(), emp.calculateDeductions(), emp.calculateNetSalary(), "\n"));
                }
                reportWriter.close();
            } catch(IOException e) {
                System.out.println("An IO exception occurred when writing the file");
            }

        }
    }
