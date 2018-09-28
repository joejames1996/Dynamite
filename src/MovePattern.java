import com.softwire.dynamite.game.Move;

import java.util.*;

public class MovePattern
{
    private static Move lastMove;
    private static int timesInRow = 0;
    private static List<Integer> lastTimesInRow = new ArrayList<>();

    private static Random r = new Random();

    public static Move compareMove(Move move)
    {
        if(lastMove != null)
        {
            if (lastMove == move)
            {
                timesInRow++;
                if(mostCommon(lastTimesInRow) == timesInRow)
                {
                    if(move == Move.D) DynamiteBot.numDynamite--;
                    return WinningMoves.winningMoveMap.get(move);
                }
            }
            else
            {
                lastTimesInRow.add(timesInRow);
                timesInRow = 0;
                lastMove = move;
            }
        }
        return generateRandomMove(move);
    }

    private static <T> T mostCommon(List<T> list)
    {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    private static Move generateRandomMove(Move move)
    {
        List<Move> moveList = new ArrayList<>();
        for(int i = 0; i < 200; i++)
        {
            if(i < 100)
            {
                if(move != Move.P || i < 50) moveList.add(Move.R);
                if(move != Move.S || i < 50) moveList.add(Move.P);
                if(move != Move.R || i < 50) moveList.add(Move.S);
            }
            if(i < DynamiteBot.numDynamite * 3 && !(lastMove == Move.D && timesInRow > 0)) moveList.add(Move.D);
            if(i < 4) moveList.add(Move.W);
        }

        if(DynamiteBot.getTurnNumber() % 500 == 0 && DynamiteBot.getTurnNumber() > 0)
            r = new Random();

        int randomIndex = r.nextInt(moveList.size());
        Move moveToPlay = moveList.get(randomIndex);
        if(moveToPlay == Move.D) DynamiteBot.numDynamite--;
        return moveToPlay;
    }
}
