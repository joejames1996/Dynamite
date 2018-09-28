public class PlayingBot
{
    private int numDynamite;

    public PlayingBot()
    {
        this.numDynamite = 100;
    }

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
        setNumDynamite(getNumDynamite() - 1);
    }
}
