
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
}
