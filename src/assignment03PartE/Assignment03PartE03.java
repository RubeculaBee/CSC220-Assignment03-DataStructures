/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE03.java
 * Author: Duc Ta
 * Author: Robin Lane
 * **********************************************
 */

package assignment03PartE;

import java.util.Scanner;

public class Assignment03PartE03
{
    private static int n;
    private static LoopA a = new LoopA();
    private static LoopC c = new LoopC();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println();

            System.out.println("Please choose a value of n for the each loop (or type ! to quit)");
            n = getInput();
            if(n == -1)
                break;
            
            System.out.println();

            testTimer();

            System.out.println();

            compareTimes();
        }
    }

    private static int getInput()
    {
        int n;
        while(true)
        {
            System.out.print("  n = ");
            String response = input.nextLine();

            if(response.equals("!"))
                return -1;
            
            try {
                n = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                System.err.println("You must enter an Integer.");
                continue;
            }

            if(n <= -1)
            {
                System.err.println("You must enter a Non-Negative Integer");
                continue;
            }

            return n;
        }
    }

    private static void testTimer()
    {
        System.out.print("Loop A: ");
        a.run(n);
        System.out.println("Done");
        a.displayTime();

        System.out.println();

        System.out.print("Loop C: ");
        c.run(n);
        System.out.println("Done");
        c.displayTime();
    }

    private static void compareTimes()
    {
        if(a.runTime < c.runTime)
            System.out.println("Loop A Completed First!");
        else if(a.runTime > c.runTime)
            System.out.println("Loop C Completed First!");
        else
            System.out.println("Both Loops completed in the same time!");
    }	
}