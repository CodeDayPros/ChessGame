import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Bishop extends Piece
{
    public Bishop(int x, int y)
    {
        super(x,y);
    }

    public String getImagePath()
    {
        return "Bishop.png";
    }

    public String getName()
    {
        return "Bishop";
    }

    public List<Point> listOfPositions()
    {
        List<Point> points = new ArrayList<Point>();
        for(int i=1; i<8; i++)
        {
            points.add(new Point(getX()+i,getY()+i));
            points.add(new Point(getX()-i,getY()+i));
            points.add(new Point(getX()+i,getY()-i));
            points.add(new Point(getX()-i,getY()-i));
        }

        return points;
    }
}