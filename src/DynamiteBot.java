import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

import java.util.Random;

public class DynamiteBot implements Bot
{
    public static final PlayingBot playingBot = new PlayingBot();
    public static final int roundLimit = 2500;

    Random r = new Random();

    public Move makeMove(Gamestate gamestate)
    {
        //MoveTrack.numMovesToTrack = MoveTrack.r.nextInt(2) + 2;
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
        MovesToList movesToList = moveTrack.calculateNextMoveChances();

        Move move = movesToList.getMove();

        if(move == null)
            return Move.R;

        if(tiedLastRound(gamestate))
        {
            int rand = r.nextInt(2);
            Move m = rand > 0 ? Move.D : Move.W;
            move = Move.W;
        }

        if(move.equals(Move.D))
            playingBot.decreaseDynamite();

        return move;
    }

    private boolean tiedLastRound(Gamestate gamestate)
    {
        int lastRoundNum = gamestate.getRounds().size();
        if(lastRoundNum < 1) return false;
        Round lastRound = gamestate.getRounds().get(lastRoundNum - 1);
        if(lastRound.getP1().equals(lastRound.getP2()))
            return true;
        return false;
    }
}
