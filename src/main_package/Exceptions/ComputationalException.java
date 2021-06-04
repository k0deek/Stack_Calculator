package main_package.Exceptions;

public class ComputationalException extends MainExceptions{
    ComputationalException(String error) {
        super("Problem with computational: " +error);
    }
}
