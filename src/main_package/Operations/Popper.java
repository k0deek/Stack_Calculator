package main_package.Operations;
import main_package.Exceptions.*;
import main_package.Context;
import main_package.Exceptions.NotEnoughArgsException;

import java.util.logging.Logger;

public class Popper implements Product {
    private static Logger log = Logger.getLogger(Definer.class.getName());
    public void doWork(Context context) throws MainExceptions {
        String str;

        if (context.getNums().empty()) throw new NotEnoughArgsException("Popper");

        str = context.getNums().pop();

        log.info("Popped element was: " + str + ". Success");
    }

    public Boolean isCorrect(Context context) {
        return (context.getSplStr().length == 1);
    }

    public Popper() {
    }
}