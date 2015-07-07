
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
    private List<Point> finalLocations;

    private Point previousLoc;
    private Point newLoc;
    private int animationTimer;

    private Piece selectedPiece;
    private List<Point> possibleMovementLocations;

    private BoardState state;

    public Board(List<Piece> x, int[][] p, List<Point> l)
    {
        positions = p;
        pieces = x;
        finalLocations = l;
        possibleMovementLocations = new ArrayList<Point>();
        state = BoardState.NONE;
        animationTimer = -1;
    }

    public Board()
    {
        this(new ArrayList<Piece>(), new int[8][8], new ArrayList<Point>());
    }

    public BoardState getState()
    {
        return state;
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
        updatePossibleLocations();
    }

    private List<Point> getPossibleLocations(Piece piece)
    {
        List<Point> locations = new ArrayList<Point>();
        for (Point location : piece.listOfPositions())
        {
            int x = (int)location.getX();
            int y = (int)location.getY();
            if (x >= 0 && x <= 7 && y >= 0 && y <= 7
            && getPiece(x, y) == null && getValue(x, y) > 0)
            {
                boolean addLocation = true;
                for (Piece otherPiece : pieces)
                {
                    MathVector u = new MathVector((int)(otherPiece.getX() - piece.getX()), (int)(otherPiece.getY() - piece.getY()));
                    MathVector v = new MathVector((int)(x - piece.getX()), (int)(y - piece.getY()));
                    if (Math.abs(u.dotProduct(v)/(u.magnitude()*v.magnitude()) - 1) < 0.0001 && u.magnitude() < v.magnitude())
                    {
                        addLocation = false;
                        break;
                    }
                }
                if (addLocation)
                    locations.add(location);
            }
        }
        return locations;
    }

    private void updatePossibleLocations()
    {
        possibleMovementLocations = getPossibleLocations(selectedPiece);
    }

    private void updateWinLoss()
    {
        if (checkWin())
            state = BoardState.WON;
        else if (checkLoss())
            state = BoardState.LOST;
    }

    private boolean checkWin()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (getValue(x, y) > 0)
                    return false;
            }
        }
        for (Point location : finalLocations)
        {
            if (getPiece((int)location.getX(), (int)location.getY()) == null)
                return false;
        }
        return true;
    }

    private boolean checkLoss()
    {
        for (Point location : finalLocations)
        {
            int x = (int)location.getX();
            int y = (int)location.getY();
            if (getPiece(x,y) == null && getValue(x,y) == 0)
                return true;
        }
        for (Piece piece : pieces)
        {
            if (getPossibleLocations(piece).size() > 0)
                return false;
        }
        return true;
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
                {
                    if ((x + y) % 2 == 0)
                        g.setColor(new Color(150, 150, 150));
                    else
                        g.setColor(new Color(120, 120, 120));
                }
                else if (valueAtPosition == 1)
                    g.setColor(new Color(225, 0, 0));
                else if (valueAtPosition == 2)
                    g.setColor(new Color(225, 0, 225));
                g.fillRect(x*50, y*50, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(x*50, y*50, 50, 50);
            }
        }

        for (Point location : finalLocations)
        {
            for (int pos = 0; pos <= 50; pos += 5)
            {
                int x = (int)location.getX()*50;
                int y = (int)location.getY()*50;
                g.setColor(Color.WHITE);
                g.drawLine(x, y+pos, x+pos, y);
                g.drawLine(x + 50, y + 50 - pos, x + 50 - pos, y + 50);
            }
        }

        for (Point location : possibleMovementLocations)
        {
            g.setColor(Color.GREEN);
            g.drawRect((int)location.getX()*50, (int)location.getY()*50, 50, 50);
        }

        if (selectedPiece != null)
        {
            g.setColor(Color.YELLOW);
            g.drawRect(selectedPiece.getX()*50, selectedPiece.getY()*50, 50, 50);
        }

        for (Piece piece : pieces)
        {
            if (animationTimer < 0 || piece != selectedPiece)
                g.drawImage(piece.getImage(), piece.getX()*50, piece.getY()*50, 50, 50, null);
        }

        if (animationTimer >= 0)
        {
            g.drawImage(selectedPiece.getImage(),
                (int)((newLoc.getX() + (previousLoc.getX() - newLoc.getX())*(animationTimer/10.))*50+0.5),
                (int)((newLoc.getY() + (previousLoc.getY() - newLoc.getY())*(animationTimer/10.))*50+0.5),
                50, 50, null);
            animationTimer--;
        }
    }

    public void clickOnBoard(int x, int y)
    {
        if (state == BoardState.NONE && animationTimer == -1)
        {
            int gridX = x/50;
            int gridY = y/50;
            if (gridX < 0 || gridX > 7 || gridY < 0 || gridY > 7)
                return;
            Piece piece = getPiece(gridX, gridY);
            if (piece != null)
                selectPiece(piece);
            else
            {
                for (Point location : possibleMovementLocations)
                {
                    if (gridX == (int)location.getX() && gridY == (int)location.getY())
                    {
                        previousLoc = new Point(selectedPiece.getX(), selectedPiece.getY());
                        newLoc = new Point(gridX, gridY);
                        animationTimer = 10;
                        selectedPiece.setPos(gridX, gridY);
                        setValue(gridX, gridY, getValue(gridX, gridY) - 1);
                        updatePossibleLocations();
                        updateWinLoss();
                        return;
                    }
                }
            }
        }
    }

}
