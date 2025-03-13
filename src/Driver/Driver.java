package Driver;
import java.io.*;
import java.util.Scanner;

import Exceptions.MinimumWageException;
import Employee.Employee;

//import java.io.printWriter;

//-----------------------------------------------------------
// Assignment 2
// Written by: Gabriel Lippé (40316342) and Noah Beauchemin (40313066)
// General explanation: This program reads a payroll file and processes it
// to calculate the net salary, tax deductions and the yearly gross salary.
// It then generates a report file with an employee's information in a
// tabular format.
//-----------------------------------------------------------
public class Driver {
    private static Employee[] employees = new Employee[100];
    private static int employeeCount = 0;

    public class Main {
        public static void main(String[] args) {
            System.out.println("Welcome to the payroll file processor program by Gabriel Lippé and Noah Beauchemin.");

            readPayrollFile("payroll.txt");
            writeReport("report.txt");
        }

        private static void readPayrollFile(String fileName) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null && employeeCount < 100) {

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

                    // Create a new employee object
                    Employee emp = new Employee(employeeNumber, firstName, lastName, hourlyWage, hoursWorked, grossSalary);
                    employees[employeeCount++] = emp;
                }
            } catch (MinimumWageException e) {
                System.out.println("Hourly wage must be greater than 15.75");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Something went wrong with the file");
            }
        }

        private static void writeReport(String fileName) {
            try{ BufferedWriter reportWriter = new BufferedWriter(new FileWriter(fileName));
                reportWriter.write("Emp #   First Name   Last Name   Gross Salary   Deductions   Net Salary\n");
                reportWriter.write("--------------------------------------------------------------\n");

                for (int i=0; i<employeeCount; i++){

                }
            }catch(IOException e){

            }


        }
    }
}



        /*
        private static void readPayrollFile(String fileName) {
            try { Scanner inFile = new Scanner(new FileInputStream(fileName));
                PrintWriter errorWriter = new PrintWriter(new FileWriter("error.txt"));

                while (inFile.hasNextLine() && employeeCount < 100) {
                    String line = inFile.nextLine();
                    String[] parts = line.split("\\s+");
                    if (parts.length != 5) {
                        throw new IllegalArgumentException("Invalid number of fields in: " + line);
                    }

                    long employeeNumber = Long.parseLong(parts[0]);
                    String firstName = inFile.next();
                    String lastNAme = inFile.next();
                    double hourlyWage = inFile.nextDouble();
                    double hoursWorked = inFile.nextDouble();

                    Employee employee = new Employee(employeeNumber, firstName, lastNAme, hourlyWage, hoursWorked, );

                }
            }

            catch (Exception e) {

            }

        }



    }
}
*/