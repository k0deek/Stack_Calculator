package main_package;

import main_package.Creators.*;
import main_package.Operations.*;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;
import java.io.*;
import java.lang.*;
import main_package.Exceptions.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser {
    private final TreeMap<String, Class> ProductName;
    public Parser(String configFile) {
        ProductName = new TreeMap<>();
        try {
            File file = new File(configFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader buf = new BufferedReader(fileReader);
            String line = buf.readLine();
            while (line != null) {
                try {
                    String[] separateWords;
                    String delimeter = " ";
                    separateWords = line.split(delimeter);
                    ProductName.put(separateWords[0], Class.forName("main_package.Creators" + "." + separateWords[1]));
                    line = buf.readLine();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        catch (IOException ioErr) {
            ioErr.printStackTrace();
        }
    }

    public Creator makeInstruction(String Name) {
        Creator newInst = null;
        try {
            newInst = (Creator) ProductName.get(Name).getDeclaredConstructor().newInstance();
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException er) {
            er.printStackTrace();
        }
        return newInst;
    }
}
