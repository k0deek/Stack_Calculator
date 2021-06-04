package main_package.Operations;
import main_package.Exceptions.*;
import main_package.Context;
import main_package.Exceptions.NegativeNumberException;
import java.util.logging.Logger;

import static java.lang.Math.sqrt;

public class SquareRooter implements Product {
    private static Logger log = Logger.getLogger(Definer.class.getName());

    //Get a number from context and find sqrt of it (if possible, else - ignore)
    public void doWork(Context context) throws MainExceptions {
        Double num;

        num = context.getANumber();
        if (num < 0.0) {
            context.setNums(num.toString());
            throw new NegativeNumberException("SquareRooter");
        }
        num = sqrt(num);
        context.setNums(num.toString());

        log.info("Sqrt successfully");
    }

    public Boolean isCorrect(Context context) {
        return (context.getSplStr().length == 1);
    }

    public SquareRooter() {

    }
}