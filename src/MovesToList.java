import com.softwire.dynamite.game.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MovesToList
{
    Random r = new Random();

    private int rockChance;
    private int paperChance;
    private int scissorsChance;
    private int dynamiteChance;
    private int waterChance;

    private Move moveToPlay;

    private boolean isRandomMove;

    public static List<Move> movesToPlay;

    public MovesToList(int rockChance, int paperChance, int scissorsChance, int dynamiteChance, int waterChance)
    {
        isRandomMove = true;
        this.rockChance = rockChance;
        this.paperChance = paperChance;
        this.scissorsChance = scissorsChance;
        this.dynamiteChance = dynamiteChance;
        this.waterChance = waterChance;
        this.movesToPlay = createMovesList();
    }

    public MovesToList(Move move)
    {
        isRandomMove = false;
        this.moveToPlay = move;
    }

    public List<Move> createMovesList()
    {
        movesToPlay = new ArrayList<>();
        Move[] rockMoves = new Move[getRockChance()];
        Move[] paperMoves = new Move[getPaperChance()];
        Move[] scissorsMoves = new Move[getScissorsChance()];
        Move[] dynamiteMoves = new Move[getDynamiteChance()];
        Move[] waterMoves = new Move[getWaterChance()];

        Arrays.fill(rockMoves, Move.R);
        Arrays.fill(paperMoves, Move.P);
        Arrays.fill(scissorsMoves, Move.S);
        Arrays.fill(dynamiteMoves, Move.D);
        Arrays.fill(waterMoves, Move.W);

        movesToPlay.addAll(Arrays.asList(rockMoves));
        movesToPlay.addAll(Arrays.asList(paperMoves));
        movesToPlay.addAll(Arrays.asList(scissorsMoves));
        movesToPlay.addAll(Arrays.asList(dynamiteMoves));
        movesToPlay.addAll(Arrays.asList(waterMoves));

        return movesToPlay;
    }

    public int getRockChance()
    {
        return rockChance;
    }

    public int getPaperChance()
    {
        return paperChance;
    }

    public int getScissorsChance()
    {
        return scissorsChance;
    }

    public int getDynamiteChance()
    {
        return dynamiteChance;
    }

    public int getWaterChance()
    {
        return waterChance;
    }

    public Move getMove(List<Move> movesList)
    {
        int moveIndex = r.nextInt(movesList.size());

        return movesList.get(moveIndex);
    }

    public Move getMove(Move move)
    {
        return move;
    }

    public Move getMove()
    {
        if(isRandomMove)
            return getMove(this.movesToPlay);
        else return getMove(this.moveToPlay);
    }
}
