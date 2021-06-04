package main_package.Exceptions;

public class NotANumberException extends MainExceptions {
    public NotANumberException(String error){
        super("Not a number: " +error);
    }
}