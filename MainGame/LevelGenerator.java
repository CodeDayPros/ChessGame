import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class LevelGenerator
{
    private int currentLevel;
    private Board board;

    public LevelGenerator()
    {
        currentLevel = 2;
    }

    public Board nextLevel()
    {
        currentLevel++;
        return generateLevel();
    }
    
    public Board restartLevel()
    {
        return generateLevel();
    }
    
    public int getCurrentLevel()
    {
        return currentLevel;
    }

    private Board generateLevel()
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
        if(currentLevel==2)
        {
            pieces.add(new Rook(6,5));
            finalLocations.add(new Point(2,7));
            positions[2][7]=1;
            positions[0][0]=1;
            positions[0][2]=1;
            positions[3][0]=1;
            positions[3][2]=1;
            positions[3][5]=1;
            positions[3][7]=1;
            positions[6][7]=1;
        }
        if(currentLevel==3)
        {
            pieces.add(new Bishop(1,7));
            pieces.add(new Knight(6,3));
            finalLocations.add(new Point(5,3));
            finalLocations.add(new Point(1,5));
            positions[5][3]=1;
            positions[1][5]=1;
            positions[5][1]=1;
            positions[3][2]=1;
            positions[3][3]=1;
            positions[7][2]=1;
            positions[4][4]=1;
            positions[5][5]=1;
            positions[0][6]=1;
            positions[3][7]=1;
            
        }
        
        board = new Board(pieces, positions, finalLocations);
        return board;
    }
}
