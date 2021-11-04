package com.company;

import java.util.*;

public class ConsoleApplication {
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args)
    {
       boolean error = false;
       do {
           System.out.println("");
           System.out.println("Input operands and operator :");
           System.out.println("");
           String str = scanner.nextLine();
           StringParser parser = new StringParser();
           str = str.replaceAll("\\s+", "");
           try
           {
               parser.scanString(str);


           }
           catch (Exception e)
           {
               System.out.println(e.getMessage());
               error = true;
           }
       }
       while (!error);


    }
}