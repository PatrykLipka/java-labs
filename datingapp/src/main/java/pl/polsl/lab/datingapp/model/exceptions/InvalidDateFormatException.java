package pl.polsl.lab.datingapp.model.exceptions;

/**
 * Invalid date format exception class
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class InvalidDateFormatException extends Exception {
    public InvalidDateFormatException(String errorMessage) {
        super(errorMessage);
    }
}
