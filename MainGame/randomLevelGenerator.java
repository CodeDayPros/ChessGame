
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
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.util.Map;
import java.util.HashMap;
/**
 * Class randomLevelGenerator - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class randomLevelGenerator extends JApplet
{
    private final int WIDTH = 430;
    private final int HEIGHT = 400;
    private Graphics graphics;
    private Image image;
    private List<Piece> pieces;
    private Map<Piece, Point> map;
    private int knights;
    private int kings;
    private int queens;
    private int rooks;
    private int bishops;
    private boolean[][] pieceThere;
    private boolean[][] fpositionThere;
    public void init()
    {
        image = createImage(WIDTH,HEIGHT);
        this.setLayout(null);
        graphics=image.getGraphics();
        pieces = new ArrayList<Piece>();
        pieceThere=new boolean[8][8];
        map = new HashMap<Piece, Point>(64);
        fpositionThere = new boolean[8][8];
        for(int row=0; row<8; row++)
        {
            for(int col=0; col<8; col++)
            {
                pieceThere[row][col]=false;
                fpositionThere[row][col]=false;
            }
        }

        for(int i=0; i<knights; i++)
        {
            int randomX = (int) (Math.random()*350);
            int randomY = (int) (Math.random()*350);
            randomX-= randomX%50;
            randomY-= randomY%50;
            if(pieceThere[randomX/50][randomY/50])
                i--;
            else
            {
                Piece knight = new Knight(randomX, randomY);
                pieces.add(knight);
                pieceThere[randomX/50][randomY/50]=true;
                do
                {
                    randomX = (int) (Math.random()*8);
                    randomY = (int) (Math.random()*8);
                    if(fpositionThere[randomX][randomY]==false)
                    {
                        map.put(knight, new Point(randomX, randomY));
                        fpositionThere[randomX][randomY]=true;
                    }
                }while(fpositionThere[randomX][randomY]==false);

            }
        }

        for(int i=0; i<rooks; i++)
        {
            int randomX = (int) (Math.random()*350);
            int randomY = (int) (Math.random()*350);
            randomX-= randomX%50;
            randomY-= randomY%50;
            if(pieceThere[randomX/50][randomY/50])
                i--;
            else
            {
                Piece rook = new Rook(randomX, randomY);
                pieces.add(rook);
                pieceThere[randomX/50][randomY/50]=true;

                do
                {
                    randomX = (int) (Math.random()*8);
                    randomY = (int) (Math.random()*8);
                    if(fpositionThere[randomX][randomY]==false)
                    {
                        map.put(rook, new Point(randomX, randomY));
                        fpositionThere[randomX][randomY]=true;
                    }
                }while(fpositionThere[randomX][randomY]==false);

            }
        }
        for(int i=0; i<kings; i++)
        {
            int randomX = (int) (Math.random()*350);
            int randomY = (int) (Math.random()*350);
            randomX-= randomX%50;
            randomY-= randomY%50;
            if(pieceThere[randomX/50][randomY/50])
                i--;
            else
            {
                Piece king = new King(randomX, randomY);
                pieces.add(king);
                pieceThere[randomX/50][randomY/50]=true;
                do
                {
                    randomX = (int) (Math.random()*8);
                    randomY = (int) (Math.random()*8);
                    if(fpositionThere[randomX][randomY]==false)
                    {
                        map.put(king, new Point(randomX, randomY));
                        fpositionThere[randomX][randomY]=true;
                    }
                }while(fpositionThere[randomX][randomY]==false);
            }
        }
        for(int i=0; i<bishops; i++)
        {
            int randomX = (int) (Math.random()*350);
            int randomY = (int) (Math.random()*350);
            randomX-= randomX%50;
            randomY-= randomY%50;
            if(pieceThere[randomX/50][randomY/50])
                i--;
            else
            {
                Piece bishop = new Bishop(randomX, randomY);
                pieces.add(bishop);
                pieceThere[randomX/50][randomY/50]=true;
                do
                {
                    randomX = (int) (Math.random()*8);
                    randomY = (int) (Math.random()*8);
                    if(fpositionThere[randomX][randomY]==false)
                    {
                        map.put(bishop, new Point(randomX, randomY));
                        fpositionThere[randomX][randomY]=true;
                    }
                }while(fpositionThere[randomX][randomY]==false);
            }
        }
        for(int i=0; i<queens; i++)
        {
            int randomX = (int) (Math.random()*350);
            int randomY = (int) (Math.random()*350);
            randomX-= randomX%50;
            randomY-= randomY%50;
            if(pieceThere[randomX/50][randomY/50])
                i--;
            else
            {
                Piece queen = new Queen(randomX, randomY);
                pieces.add(queen);
                pieceThere[randomX/50][randomY/50]=true;
                do
                {
                    randomX = (int) (Math.random()*8);
                    randomY = (int) (Math.random()*8);
                    if(fpositionThere[randomX][randomY]==false)
                    {
                        map.put(queen, new Point(randomX, randomY));
                        fpositionThere[randomX][randomY]=true;
                    }
                }while(fpositionThere[randomX][randomY]==false);
            }
        }

        repaint();
    }

    public randomLevelGenerator(int kn , int b, int k, int r, int q)
    {
        knights = kn;
        bishops = b;
        kings = k;
        rooks = r;
        queens = q;
    }

    public List<Point> regularPositions(Piece p, Point point)
    {
        boolean done = true;
        ArrayList<Point> result = new ArrayList<Point>();
        if(p.getName().equals("Knight"))
        {

            //algoritm for connecting knight to final position
        }
        else if(p.getName().equals("Rook"))
        {
            //algoritm for connecting knight to final position
        }
        else if(p.getName().equals("Queen"))
        {
            //algoritm for connecting knight to final position
        }
        else if(p.getName().equals("King"))
        {
            //algoritm for connecting knight to final position
        }
        else if(p.getName().equals("Bishop"))
        {
            //algoritm for connecting knight to final position
        }
        return null;
    }

    public void paint(Graphics g)
    {      

        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if ((x + y) % 2 == 0)
                    graphics.setColor(new Color(150, 150, 150));
                else
                    graphics.setColor(new Color(120, 120, 120));
                graphics.fillRect(x*50,y*50,50,50);
                graphics.setColor(Color.BLACK);
                graphics.drawRect(x*50, y*50, 50, 50);

            }
        }

        for(Piece p: pieces)
        {
            graphics.drawImage(p.getImage(),p.getX(),p.getY(),this);
            Point point = map.get(p);
            graphics.setColor(Color.RED);
            graphics.fillRect((int)(point.getX())*50, (int)(point.getY())*50,50,50);
            // drawRegularPositions(p,point);
            for (int pos = 0; pos <= 50; pos += 5)
            {
                int x = (int)point.getX()*50;
                int y = (int)point.getY()*50;
                graphics.setColor(Color.WHITE);
                graphics.drawLine(x, y+pos, x+pos, y);
                graphics.drawLine(x + 50, y + 50 - pos, x + 50 - pos, y + 50);
            }
        }

        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                graphics.setColor(Color.BLACK);
                graphics.drawRect(x*50, y*50, 50, 50);
            }
        }
        g.drawImage(image, 0, 0, this);

    }
}
