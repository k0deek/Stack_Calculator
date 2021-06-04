package main_package.Exceptions;

import main_package.Main;

public class NotEnoughArgsException extends ArgsExceptions {
    public NotEnoughArgsException(String error){
        super("Not enough arguments: " +error);
    }
}