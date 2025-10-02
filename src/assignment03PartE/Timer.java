package assignment03PartE;

public class Timer
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
