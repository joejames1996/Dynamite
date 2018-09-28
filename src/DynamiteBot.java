import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

public class DynamiteBot implements Bot
{
    public static final PlayingBot playingBot = new PlayingBot();
    public static final int roundLimit = 2500;

    public Move makeMove(Gamestate gamestate)
    {
        int lastRoundNum = gamestate.getRounds().size();
        Round[] rounds = new Round[roundLimit];
        Move[] moves = new Move[MoveTrack.numMovesToTrack];

        gamestate.getRounds().toArray(rounds);

        if(lastRoundNum > MoveTrack.numMovesToTrack)
        {
            for(int i = lastRoundNum - MoveTrack.numMovesToTrack, j = 0; j < MoveTrack.numMovesToTrack; i++, j++)
            {
                moves[j] = rounds[i].getP2();
            }
        }
        else
        {
            for(int i = 0; i < lastRoundNum; i++)
            {
                moves[i] = rounds[i].getP2();
            }
        }

        MoveTrack moveTrack = new MoveTrack(moves);
        MovesToList movesToList = moveTrack.calculateNextMoveChances(gamestate);

        Move move = movesToList.getMove();

        if(move == null)
            return Move.R;

        if(move == Move.D)
            playingBot.decreaseDynamite();

        return move;
    }

    private boolean tiedLastRound(Gamestate gamestate)
    {
        int lastRoundNum = gamestate.getRounds().size();
        Round lastRound = gamestate.getRounds().get(lastRoundNum);
        if(lastRound.getP1().equals(lastRound.getP2()))
            return true;
        return false;
    }
}
