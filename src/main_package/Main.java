package main_package;

import main_package.Exceptions.IncorrectNumOfArgs;
import main_package.Exceptions.MainExceptions;
import main_package.Operations.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import main_package.Creators.*;


public class Main {

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/log4j.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }


        Parser parser = new Parser("D:\\lab2\\src\\main_package\\Config.txt");
        Context context = new Context();
        try {
            Creator creator;
            if (args.length == 0) {
                Scanner in = new Scanner(System.in);
                while (in.hasNext()) {
                    String line = in.nextLine();
                    if (line.charAt(0) == '#') {
                        continue;
                    }
                    String[] comArgs;
                    String delimeter = " ";
                    comArgs = line.split(delimeter);
                    creator = parser.makeInstruction(comArgs[0]);
                    try {
                        Product prod = creator.create();
                    }
                    catch (Exception e) {
                        Logger.getGlobal().log(Level.WARNING, e.toString());
                    }
                }
            }
            else {
                File file = new File(args[0]);
                FileReader fileReader = new FileReader(file);
                BufferedReader buf = new BufferedReader(fileReader);
                String line = buf.readLine();

                while (line != null) {
                    if (line.charAt(0) == '#') {
                        line = buf.readLine();
                        continue;
                    }
                    context.setSplStr(line);
                    String[] comArgs;
                    String delimeter = " ";
                    comArgs = line.split(delimeter);
                    creator = parser.makeInstruction(comArgs[0]);
                    try {
                        Product prod = creator.create();
                        if (!prod.isCorrect(context)) throw new IncorrectNumOfArgs("main");
                        prod.doWork(context);
                        if (context.getSplStr()[0].equals("END")) return;
                    }
                    catch (Exception e) {
                        Logger.getGlobal().log(Level.WARNING, e.toString());
                        e.printStackTrace();
                    }

                    line = buf.readLine();
                }

            }
        }
        catch (IOException ioErr) {
            ioErr.printStackTrace();
        }
    }
}
