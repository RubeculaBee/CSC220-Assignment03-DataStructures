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
        Timer myTimer = new Timer();

        int n = 50000;

        System.out.println("Loop A: ");
        myTimer.start();
        LoopA.run(n);
        LoopA.runTime = myTimer.stop();
        LoopA.displayTime();

        System.out.println();

        System.out.println("Loop B: ");
        myTimer.start();
        LoopB.run(n);
        LoopB.runTime = myTimer.stop();
        LoopB.displayTime();
        
    }
}