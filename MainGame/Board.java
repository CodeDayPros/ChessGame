
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;
public class Board
{

    private List<Piece> pieces;
    private int[][] positions;
    public Board(ArrayList<Piece> x, int[][] p)
    {
        positions= p;
        pieces=x;

    }

    public Board()
    {
        positions= new int[8][8]; 
        pieces = new ArrayList<Piece>();
    }

    public Piece getPiece(int x, int y)
    {
        for(Piece p: pieces)
        {
            if(p.getX()==x &&p.getY()==y)
                return p;
        }
        return null;
    }

    public int getValue(int x, int y)
    {
        return positions[x][y];
    }

    public void setValue(int x, int y, int value)
    {
        positions[x][y]=value;
    }

}
