package Exceptions;

public class MinimumWageException extends Exception {


    public MinimumWageException(String errorMessage) {
        // Ensure message isn't null and is initialized
    super(errorMessage);
    }

}
