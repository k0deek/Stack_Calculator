package main_package.Exceptions;

public class NegativeNumberException extends ComputationalException {
    public NegativeNumberException(String error){
        super("Can't work with negative numbers: " + error);
    }
}