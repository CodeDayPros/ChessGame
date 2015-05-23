
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Rook extends Piece
{
    public Rook(int x, int y)
    {
        super(x,y);
    }

    public BufferedImage getImage()
    {

        try {
            BufferedImage image= ImageIO.read(new File("Rook.png"));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName()
    {
        return "Rook";
    }

    public List<Point> listOfPositions()
    {
        List<Point> points = new ArrayList<Point>();
        for(int i=1; i<8; i++)
        {
            points.add(new Point(getX()+i,getY()));
            points.add(new Point(getX()-i,getY()));
            points.add(new Point(getX(),getY()+i));
            points.add(new Point(getX(),getY()-i));
        }

        return points;
    }
}