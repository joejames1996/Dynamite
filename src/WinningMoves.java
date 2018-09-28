import com.softwire.dynamite.game.Move;

import java.util.Map;

public class WinningMoves
{
    public static Map<Move, Move> winningMoveMap;
    static
    {
        winningMoveMap.put(Move.R, Move.P);
        winningMoveMap.put(Move.P, Move.S);
        winningMoveMap.put(Move.S, Move.R);
        winningMoveMap.put(Move.W, Move.R);
        winningMoveMap.put(Move.D, Move.W);
    }
}
