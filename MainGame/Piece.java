
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
    public Piece(String str, BufferedImage pic)
    {
        name=str;
        image = pic;
    }
    public String getName()
    {
        return name;
    }
}
