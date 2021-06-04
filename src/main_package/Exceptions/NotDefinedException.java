package main_package.Exceptions;

import main_package.Main;

public class NotDefinedException extends MainExceptions {
    public NotDefinedException(String error){
        super("Not defined: " +error);
    }
}