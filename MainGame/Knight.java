
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Knight extends Piece
{
    public Knight(int x, int y)
    {
        super(x,y);
    }

    public BufferedImage getImage()
    {

        try {
            BufferedImage image= ImageIO.read(new File("Knight.png"));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
