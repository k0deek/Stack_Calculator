package main_package.Exceptions;

public class IncorrectNumOfArgs extends ArgsExceptions {
    public IncorrectNumOfArgs(String error){
        super("IncorrectNumOfArgs: " +error);
    }
}