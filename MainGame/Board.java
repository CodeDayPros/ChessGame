
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

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
    
    public void drawBoard(Graphics g)
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                int valueAtPosition = getValue(x, y);
                if (valueAtPosition == 0)
                    g.setColor(Color.WHITE);
                else
                    g.setColor(Color.RED);
                g.fillRect(x*50, y*50, 50, 50);
                
                g.setColor(Color.BLACK);
                g.drawRect(x*50, y*50, 50, 50);
                
                Piece piece = getPiece(x, y);
                if (piece != null)
                    g.drawImage(piece.getImage(), x*50, y*50, 50, 50, null);
            }
        }
    }

}
