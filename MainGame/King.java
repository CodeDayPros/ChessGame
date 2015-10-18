import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class King extends Piece
{
    public King(int x, int y)
    {
        super(x,y);
    }

    public String getImagePath()
    {
        return "King.png";
    }

    public String getName()
    {
        return "King";
    }

    public List<Point> listOfPositions()
    {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(getX()+1, getY()+1));
        points.add(new Point(getX()+1, getY()-1));
        points.add(new Point(getX()-1, getY()+1));
        points.add(new Point(getX()-1, getY()-1));
        points.add(new Point(getX(), getY()-1));
        points.add(new Point(getX(), getY()+1));
        points.add(new Point(getX()-1, getY()));
        points.add(new Point(getX()+1, getY()));
        return points;
    }
}
