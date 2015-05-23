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
            pieces.add(new Knight(2, 0));
            finalLocations.add(new Point(1, 2));
            positions[4][1] = 1;
            positions[6][0] = 1;
            positions[7][1] = 1;
            positions[5][2] = 1;
            positions[6][3]=1;
            positions[3][3]=1;
            positions[4][4]=1;
            positions[2][5]=1;
            positions[1][2]=1;
        }
        board = new Board(pieces, positions, finalLocations);
    }
    
    public Board getBoard()
    {
        return board;
    }
}
