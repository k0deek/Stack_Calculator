package main_package.Exceptions;

public class ArgFormatException extends ArgsExceptions {
    public ArgFormatException(String error){
        super("First argument must be a string, second - a number: "+error);
    }
}
