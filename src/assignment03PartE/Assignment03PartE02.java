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
    private static long initialTime;
    private static long endTime;
    private static long timeElapsed;

    public static void main(String[] args)
    {
        int n = 1000;

        System.out.println("Loop A: ");
        startTimer();
        loopA(n);
        stopTimer();
        displayTime();

        System.out.println("\nLoop B: ");
        startTimer();
        loopB(n);
        stopTimer();
        displayTime();
        
    }

    private static void loopA(int n)
    {
        int sum = 0, i, j;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= 10000; j++)
                sum = sum + j;
    }

    private static void loopB(int n)
    {
        int sum = 0, i, j;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                sum = sum + j;
    }

    private static void startTimer()
    {
        initialTime = System.currentTimeMillis();
    }

    private static void stopTimer()
    {
        endTime = System.currentTimeMillis();

        timeElapsed = endTime - initialTime;
    }

    private static void displayTime()
    {
        System.out.printf("Time Elapsed: %5dms\n", timeElapsed);
    }
}