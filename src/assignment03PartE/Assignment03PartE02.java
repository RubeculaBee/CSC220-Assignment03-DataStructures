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

import java.util.InputMismatchException;
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

            System.out.println("Please choose a value of n for each loop");
            n = getInput();

            System.out.println();

            testTimer();
            
            System.out.println();
            
            requestExit();
        }
    }

    private static int getInput()
    {
        int n;
        while(true)
        {
            System.out.print("  n = ");

            try {
                n = input.nextInt();
            } catch (InputMismatchException e) {
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

    private static void requestExit()
    {
        char response = 0;
        while(!(response == 'y' || response == 'n'))
        {
            System.out.println("Would you lke to quit? (y/n)");
            try {
                response = input.nextLine().toLowerCase().charAt(0);
            } catch(StringIndexOutOfBoundsException e) {
                response = 0;
            }
        }

        if(response == 'y')
            System.exit(200);
    }
}