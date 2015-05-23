
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
    private Piece selectedPiece;
    private int[][] positions;
    private List<Point> possibleMovementLocations;

    public Board(ArrayList<Piece> x, int[][] p)
    {
        positions= p;
        pieces=x;
        possibleMovementLocations = new ArrayList<Point>();
    }

    public Board()
    {
        positions= new int[8][8]; 
        pieces = new ArrayList<Piece>();
        possibleMovementLocations = new ArrayList<Point>();
        pieces.add(new Knight(0, 0));
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

    public Piece getSelectedPiece()
    {
        return selectedPiece;
    }

    public void selectPiece(Piece piece)
    {
        selectedPiece = piece;
        possibleMovementLocations = new ArrayList<Point>();
        for (Point location : piece.listOfPositions())
        {
            int x = (int)location.getX();
            int y = (int)location.getY();
            if (getPiece(x, y) == null && getValue(x, y) > 0)
                possibleMovementLocations.add(location);
        }
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
        for (Point location : possibleMovementLocations)
        {
            g.setColor(Color.YELLOW);
            g.drawRect((int)location.getX()*50, (int)location.getY()*50, 50, 50);
        }
    }

    public void clickOnBoard(int x, int y)
    {
        int gridX = x/50;
        int gridY = y/50;
        if (gridX < 0 || gridX > 7 || gridY < 0 || gridY > 7)
            return;
        Piece piece = getPiece(gridX, gridY);
        if (piece != null)
            selectPiece(piece);
    }

}
