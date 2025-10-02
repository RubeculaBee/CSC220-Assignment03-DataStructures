package assignment03PartE;

abstract sealed class Loop
{
    Timer timer = new Timer();
    long runTime;

    void run(int n)
    {
        timer.start();
        doLoop(n);
        runTime = timer.stop();
    };

    abstract void doLoop(int n);

    void displayTime()
    {
        System.out.printf("Time Elapsed: %5dms\n", runTime);
    }
}

final class LoopA extends Loop
{
    void doLoop(int n)
    {
        int sum = 0, i, j;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= 10000; j++)
                sum = sum + j;
    }
}

final class LoopB extends Loop
{
    void doLoop(int n)
    {
        int sum = 0, i, j;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                sum = sum + j;
    }
}