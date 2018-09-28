import com.softwire.dynamite.game.Move;

public class MoveTrack
{
    public static int numMovesToTrack = 3;

    private Move[] moves = new Move[numMovesToTrack];

    public MoveTrack(Move[] moves)
    {
        this.moves = moves;
    }

    public MovesToList calculateNextMoveChances()
    {
        MovesToList movesToList;
        if (isPattern())
        {
            movesToList = usePatternChances();
        }
        else
        {
            movesToList = useRandomChances();
        }
        return movesToList;
    }

    private boolean isPattern()
    {
        if(this.moves[0] != null)
            if(this.moves[0] == this.moves[1] && this.moves[0] == this.moves[2])
                return true;
        return false;
    }

    private MovesToList usePatternChances()
    {
        Move moveToPlay = WinningMoves.moveMap.get(this.moves[0]);
        MovesToList movesToList = new MovesToList(moveToPlay);
        return movesToList;
    }

    private MovesToList useRandomChances()
    {
        MovesToList movesToList = new MovesToList(100, 100, 100, DynamiteBot.playingBot.getNumDynamite(), 5);
        return movesToList;
    }

    public MovesToList useDynamite()
    {
        if(DynamiteBot.playingBot.getNumDynamite() > 0)
        {
            MovesToList movesToList = new MovesToList(0, 0, 0, 1, 0);
            return movesToList;
        }
        return useRandomChances();
    }
}
