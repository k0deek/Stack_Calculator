package main_package.Operations;

import main_package.Context;
import main_package.Exceptions.NotEnoughArgsException;
import main_package.Exceptions.ZeroDivisionException;

import java.util.logging.Logger;
import main_package.Exceptions.*;

public class Divisioner implements Product {
    private static Logger log = Logger.getLogger(Definer.class.getName());

    public void doWork(Context context) throws MainExceptions {
        Double first, second;
        Double div;

        if (context.getNums().size() < 2) throw new NotEnoughArgsException("Divisioner");
        first = context.getANumber();
        second = context.getANumber();

        if (second == 0) throw new ZeroDivisionException("Divisioner");

        div = first / second;

        context.setNums(div.toString());

        log.info("Divided successfully");


    }

    public Boolean isCorrect(Context context) {
        return (context.getSplStr().length == 1);
    }

    public Divisioner() {
    }
}