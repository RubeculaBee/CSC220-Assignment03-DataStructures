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

    private class Timer
    {
        private long startTime;
        private long endTime;

        public Timer() {};

        public void start()
        {
            this.startTime = System.currentTimeMillis();
        }

        public long stop()
        {
            this.endTime = System.currentTimeMillis();

            return this.endTime - this.startTime;
        }
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