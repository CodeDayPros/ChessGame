
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class King extends Piece
{
    public King(int x, int y)
    {
        super(x,y);
    }

    public BufferedImage getImage()
    {

        try {
            BufferedImage image= ImageIO.read(new File("King.png"));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
       

        return points;
    }
}
