package main_package;

import main_package.Creators.*;
import main_package.Exceptions.IncorrectNumOfArgs;
import main_package.Exceptions.NotEnoughArgsException;
import main_package.Operations.*;
import main_package.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private Context context;
    private Scanner scanner;
    private static Logger log = Logger.getLogger(Definer.class.getName());

    public Parser(String filename) throws FileNotFoundException {
        File file = new File(filename);
        this.scanner = new Scanner(file);
        this.context = new Context();
    }

    public Parser(){
        this.scanner = new Scanner(System.in);
        this.context = new Context();
    }

    public void doWork() throws Exception{
        String str;
        Creator creator;

        while(this.scanner.hasNextLine()) {
            try {
                str = this.scanner.nextLine();
                this.context.setSplStr(str);
                switch (this.context.getSplStr()[0]){
                    case "#":
                        continue;
                    case "SQRT":
                        creator = new SqrtCreator();
                        break;
                    case "*":
                        creator = new MulCreator();
                        break;
                    case "/":
                        creator = new DivCreator();
                        break;
                    case "+":
                        creator = new SumCreator();
                        break;
                    case "-":
                        creator = new SubCreator();
                        break;
                    case "POP":
                        creator = new PopCreator();
                        break;
                    case "PUSH":
                        creator = new PushCreator();
                        break;
                    case "DEFINE":
                        creator = new DefCreator();
                        break;
                    case "PRINT":
                        creator = new PrintCreator();
                        break;
                    case "END":
                        return;
                    default:
                        System.out.println("Command " + str + " not found");
                        continue;
                }
                Product prod = creator.create();
                if (!prod.isCorrect(context)) throw new IncorrectNumOfArgs();
                prod.doWork(context);
                if (context.getSplStr()[0].equals("END")) return;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                log.log(Level.SEVERE, this.context.getSplStr()[0] + ": " + e.getMessage());
            }
        }
    }
}