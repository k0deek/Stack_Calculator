package main_package.Operations;

import main_package.Context;
import main_package.Exceptions.NotDefinedException;
import main_package.Exceptions.*;
import java.util.logging.Logger;

public class Pusher implements Product{

    private static Logger log = Logger.getLogger(Definer.class.getName());

    public void doWork(Context context) throws MainExceptions {
        String str = context.getSplStr()[1];

        if (!context.isNum(str)){
            if (context.getDefines().get(str) == null) throw new NotDefinedException("Pusher");
        }

        context.setNums(str);
        log.info("Pushed successfully");
    }

    public Boolean isCorrect(Context context){
        return (context.getSplStr().length == 2);
    }

    public Pusher(){
    }
}