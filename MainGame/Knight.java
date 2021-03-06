import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Knight extends Piece
{
    public Knight(int x, int y)
    {
        super(x,y);
    }

    public String getImagePath()
    {
        return "Knight.png";
    }

    public String getName()
    {
        return "Knight";
    }

    public List<Point> listOfPositions()
    {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(getX()+2, getY()+1));
        points.add(new Point(getX()+2, getY()-1));
        points.add(new Point(getX()-2, getY()+1));
        points.add(new Point(getX()-2, getY()-1));
        points.add(new Point(getX()+1, getY()-2));
        points.add(new Point(getX()+1, getY()+2));
        points.add(new Point(getX()-1, getY()-2));
        points.add(new Point(getX()-1, getY()+2));

        return points;
    }
}
