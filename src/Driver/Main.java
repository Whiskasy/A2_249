package Driver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
//import java.io.printWriter;

//-----------------------------------------------------------
// Assignment 2
// Written by: Gabriel Lippé (40316342) and Noah Beauchemin (40313066)
// General explanation: This program reads a payroll file and processes it
// to calculate the net salary, tax deductions and the yearly gross salary.
// It then generates a report file with an employee's information in a
// tabular format.
//-----------------------------------------------------------

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the payroll file processor program by Gabriel Lippé and Noah Beauchemin.");

        try {
            Scanner inFile = new Scanner(new FileReader("payroll.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}