
/**
 * Write a description of class Pieces here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public abstract class Piece
{
    private int xPos;
    private int yPos;
    private BufferedImage image;
    
    public Piece(int x, int y)
    {
        xPos=x;
        yPos=y;
        setImage();
    }
    
    private void setImage()
    {
        try {
            image= ImageIO.read(new File(getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public abstract String getName();
    
    public int getX()
    {
        return xPos;
    }
    
    public int getY()
    {
        return yPos;
    }
    
    public void setPos(int x, int y)
    {
        xPos=x;
        yPos=y;
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    public abstract String getImagePath();
    
    public abstract List<Point> listOfPositions();    
}
