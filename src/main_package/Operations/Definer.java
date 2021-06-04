package main_package.Operations;

import main_package.Exceptions.ArgFormatException;
import main_package.Context;

import main_package.Exceptions.*;
import java.util.logging.Logger;

public class Definer implements Product {
    private static Logger log = Logger.getLogger(Definer.class.getName());

    public void doWork(Context context) throws MainExceptions{
        Double num;
        String str;
        str = context.getSplStr()[1];
        try{
            Double.parseDouble(str);
            throw new ArgFormatException("Definer");
        }
        catch (NumberFormatException e){
            try{
                num = Double.parseDouble(context.getSplStr()[2]);
                context.setDefines(str, num);
                log.info("Successfully defined: " + str + " = " + num);
            }
            catch (NumberFormatException ee){
                throw new ArgFormatException("Definer");
            }
        }
    }

    public Boolean isCorrect(Context context){
        return (context.getSplStr().length == 3);
    }

    public Definer(){
    }
}