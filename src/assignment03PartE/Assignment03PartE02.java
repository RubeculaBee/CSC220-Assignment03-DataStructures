/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE02.java
 * Author: Duc Ta
 * Author: Robin Lane
 * **********************************************
 */

package assignment03PartE;

import java.util.Scanner;

public class Assignment03PartE02
{
    static int n;
    static LoopA a = new LoopA();
    static LoopB b = new LoopB();
    static Scanner input = new Scanner(System.in);

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

        System.out.print("Loop B: ");
        b.run(n);
        System.out.println("Done");
        b.displayTime();
    }
}