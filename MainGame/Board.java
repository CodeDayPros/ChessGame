
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
    public Board(List<Piece> x)
    {
        positions= new int[8][8];
        pieces=x;
        
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

    
}
