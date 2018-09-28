import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

public class DynamiteBot implements Bot
{
    private static int turnNumber = 0;
    public static int numDynamite = 100;

    public Move makeMove(Gamestate gamestate)
    {
        Move move = Move.D;
        if(turnNumber > 0)
        {
            Round round = gamestate.getRounds().get(turnNumber);
            move = round.getP2();
            turnNumber++;
        }
        return MovePattern.compareMove(move);
    }

    public static int getTurnNumber()
    {
        return turnNumber;
    }
}
