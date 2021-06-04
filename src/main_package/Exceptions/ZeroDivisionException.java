package main_package.Exceptions;

public class ZeroDivisionException extends ComputationalException {
    public ZeroDivisionException(String error){
        super("Division by zero: " +error);
    }
}