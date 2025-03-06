package Exceptions;

public class MinimumWageException extends Throwable {

    public MinimumWageException(String minimumWageMessage) {
        System.out.println("Hourly wage must be above the minimum wage of $15.75");
    }

}
