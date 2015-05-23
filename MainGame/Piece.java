
/**
 * Write a description of class Pieces here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
public class Piece
{
    private String name;
    private BufferedImage image;
    private int xPos;
    private int yPos;
    
    public Piece(String str, BufferedImage pic, int x, int y)
    {
        name=str;
        image = pic;
        xPos=x;
        yPos=y;
    }
    public String getName()
    {
        return name;
    }
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
    
}
