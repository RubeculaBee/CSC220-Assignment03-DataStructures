package assignment03PartE;

abstract sealed class Loop
{
    static long runTime;

    static void run(int n) {};

    static void displayTime()
    {
        System.out.printf("Time Elapsed: %5dms\n", runTime);
    }
}

final class LoopA extends Loop
{
    static void run(int n)
    {
        int sum = 0, i, j;
        
        for (i = 1; i <= n; i++)
            for (j = 1; j <= 10000; j++)
                sum = sum + j;
    }
}

final class LoopB extends Loop
{
    static void run(int n)
    {
        int sum = 0, i, j;

        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                sum = sum + j;
    }
}