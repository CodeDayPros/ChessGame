import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class LevelGenerator
{
    private int currentLevel;
    private Board board;

    public LevelGenerator()
    {
        currentLevel = 0;
    }

    public void nextLevel()
    {
        currentLevel++;
        generateLevel();
    }

    private void generateLevel()
    {
        List<Piece> pieces = new ArrayList<Piece>();
        List<Point> finalLocations = new ArrayList<Point>();
        int[][] positions = new int[8][8];
        if (currentLevel == 1)
        {
            pieces.add(new Knight(0, 0));
            finalLocations.add(new Point(4, 0));
            positions[2][1] = 1;
            positions[4][0] = 1;
        }
        board = new Board(pieces, positions, finalLocations);
    }
    
    public Board getBoard()
    {
        return board;
    }
}
