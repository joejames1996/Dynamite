import com.softwire.dynamite.game.Move;

import java.util.Random;

public class MoveTrack
{
    public static Random r = new Random();
    public static int numMovesToTrack = 3;

    public static int numDynamiteUsedByOtherPlayer = 0;

    private Move[] moves = new Move[numMovesToTrack];

    public MoveTrack(Move[] moves)
    {
        this.moves = moves;
    }

    public MovesToList calculateNextMoveChances()
    {
        MovesToList movesToList;
        if(moves.length > 0)
        {
            if (moves[moves.length-1] == Move.D)
            {
                numDynamiteUsedByOtherPlayer++;
            }
        }
        if (isPattern())
        {
            movesToList = usePatternChances();
        } else
        {
            movesToList = useRandomChances();
        }
        return movesToList;
    }

    private boolean isPattern()
    {
        boolean isPattern = true;
        if (this.moves[0] != null)
            for(Move m : moves)
            {
                if(m != moves[0])
                    isPattern = false;
            }
        return isPattern;
    }

    private MovesToList usePatternChances()
    {
        Move moveToPlay = WinningMoves.moveMap.get(this.moves[0]);
        MovesToList movesToList = new MovesToList(moveToPlay);
        return movesToList;
    }

    private MovesToList useRandomChances()
    {
        MovesToList movesToList = new MovesToList(1000, 1000, 1000, DynamiteBot.playingBot.getNumDynamite(), (100 - numDynamiteUsedByOtherPlayer) / 10);
        return movesToList;
    }
}
