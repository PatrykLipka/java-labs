package pl.polsl.lab.datingapp.model.exceptions;

/**
 * Empty list exception class
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class EmptyListException extends Exception {
    public EmptyListException() {
        super("Passed list is empty");
    }
}
