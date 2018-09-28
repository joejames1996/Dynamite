import com.softwire.dynamite.game.Move;

import java.util.HashMap;
import java.util.Map;

public class WinningMoves
{
    public static final Map<Move, Move> moveMap;
    static
    {
        moveMap = new HashMap<>();
        moveMap.put(Move.D, Move.W);
        moveMap.put(Move.W, Move.R);
        moveMap.put(Move.R, Move.P);
        moveMap.put(Move.P, Move.S);
        moveMap.put(Move.S, Move.R);
    }
}
