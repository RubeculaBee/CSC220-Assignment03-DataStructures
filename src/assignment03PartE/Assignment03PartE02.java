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

public class Assignment03PartE02
{
    public static void main(String[] args)
    {
        int n = 50000;
        LoopA a = new LoopA();
        LoopB b = new LoopB();

        System.out.println("Loop A: ");
        a.run(n);
        a.displayTime();

        System.out.println();

        System.out.println("Loop B: ");
        b.run(n);
        b.displayTime();
        
    }
}