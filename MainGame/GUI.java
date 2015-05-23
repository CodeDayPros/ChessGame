
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*; 
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class GUI extends Applet implements ActionListener, MouseListener
{
    Graphics graphics;
    Image image;
    final int WIDTH = 500;
    final int HEIGHT = 500;
    Board board;

    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        graphics = image.getGraphics();
        
        board = new Board();
        board.setValue(0, 1, 1); //remove this shit later
        board.setValue(2, 1, 1);
        board.setValue(4,0,1);
        addMouseListener(this);
        int delay = 20; //milliseconds
        ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    repaint();
                }
            };
        new Timer(delay, taskPerformer).start();

    }
    
    public void actionPerformed(ActionEvent ae)
    {
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {   
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        
        board.drawBoard(graphics);
        
        g.drawImage(image, 0, 0, this);
    }
    
    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
      
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
       board.clickOnBoard(e.getX(), e.getY());
    }
}

