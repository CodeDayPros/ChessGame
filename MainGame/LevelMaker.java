
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*; 
import java.awt.image.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
public class LevelMaker extends Applet implements ActionListener, MouseListener
{
    JPopupMenu popup;
    final int WIDTH = 400;
    final int HEIGHT = 435;
    JMenuItem king;
    JMenuItem queen;
    JMenuItem bishop;
    JMenuItem knight;
    JMenuItem rook;
    JMenuItem finalPos;
    JMenuItem regPos;
    Graphics graphics;
    Image image;
    Boolean drawPiece;
    List<Piece> pieces;
    List<Point> regPoints;
    List<Point> finalPoints;
    int xPos;
    int yPos;
    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        graphics=image.getGraphics();
        drawPiece=false;
        regPoints= new ArrayList<Point>();
        pieces = new ArrayList<Piece>();
        finalPoints = new ArrayList<Point>();
        this.resize(WIDTH,HEIGHT);
        popup = new JPopupMenu();
        king = new JMenuItem("Add King");
        king.addActionListener(this);
        popup.add(king);
        queen = new JMenuItem("Add Queen");
        queen.addActionListener(this);
        popup.add(queen);
        bishop = new JMenuItem("Add Bishop");
        bishop.addActionListener(this);
        popup.add(bishop);
        knight = new JMenuItem("Add Knight");
        knight.addActionListener(this);
        popup.add(knight);
        rook = new JMenuItem("Add Rook");
        rook.addActionListener(this);
        popup.add(rook);
        finalPos = new JMenuItem("Add Final Position");
        finalPos.addActionListener(this);
        popup.add(finalPos);
        regPos = new JMenuItem("Add Regular Position");
        regPos.addActionListener(this);
        popup.add(regPos);

        addMouseListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == king)
        {
            drawPiece=true;
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            pieces.add(new King(xPos,yPos));
            repaint();        
        }
        if (ae.getSource() == queen)
        {
            drawPiece=true;
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            pieces.add(new Queen(xPos,yPos));
            repaint();   
        }
        if (ae.getSource() == knight)
        {
            drawPiece=true;
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            pieces.add(new Knight(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == bishop)
        {
            drawPiece=true;
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            pieces.add(new Bishop(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == rook)
        {
            drawPiece=true;
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            pieces.add(new Rook(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == finalPos)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            regPoints.add(new Point(xPos,yPos));
            finalPoints.add(new Point(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == regPos)
        {
            
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            regPoints.add(new Point(xPos,yPos));
            repaint();
        }
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {      

        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {

                graphics.setColor(Color.GRAY);
                graphics.fillRect(x*50,y*50,50,50);
                graphics.setColor(Color.BLACK);
                graphics.drawRect(x*50, y*50, 50, 50);

            }
        }
        for(Point p: regPoints)
        {
            graphics.setColor(Color.RED);
            graphics.fillRect((int)(p.getX()), (int)(p.getY()),50,50);
        }
        for(Point p: finalPoints)
        {
           for (int pos = 0; pos <= 50; pos += 5)
            {
                int x = (int)p.getX();
                int y = (int)p.getY();
                graphics.setColor(Color.WHITE);
                graphics.drawLine(x, y+pos, x+pos, y);
                graphics.drawLine(x + 50, y + 50 - pos, x + 50 - pos, y + 50);
            }
        }

        if(drawPiece)
        {
            for(Piece p: pieces)
                graphics.drawImage(p.getImage(),p.getX(),p.getY(),this);
        }

        
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
        xPos=e.getX();
        yPos=e.getY();
        if(SwingUtilities.isRightMouseButton(e))
            popup.show(e.getComponent(), e.getX(), e.getY());
    }
}
