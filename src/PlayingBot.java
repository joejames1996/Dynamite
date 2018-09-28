public class PlayingBot
{
    private int numDynamite = 100;

    public int getNumDynamite()
    {
        return numDynamite;
    }

    public void setNumDynamite(int numDynamite)
    {
        this.numDynamite = numDynamite;
    }

    public void decreaseDynamite()
    {
        this.numDynamite--;
    }
}
