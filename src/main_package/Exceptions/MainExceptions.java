package main_package.Exceptions;

public class MainExceptions extends Exception{
    MainExceptions(String error) {
        super("Problem with: " +error);
    }
}
