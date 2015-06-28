
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
    JMenuItem regPos1;
    JMenuItem regPos2;
    Graphics graphics;
    Image image;

    Boolean[][] pieceThere;
    List<Piece> pieces;
    List<Point> regPoints1;
    List<Point> regPoints2;
    List<Point> finalPoints;

    JTextArea textArea;
    Button generateCode;
    int xPos;
    int yPos;
    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        this.setLayout(null);
        graphics=image.getGraphics();

        regPoints1= new ArrayList<Point>();
        pieces = new ArrayList<Piece>();
        finalPoints = new ArrayList<Point>();
        regPoints2= new ArrayList<Point>();
        textArea = new JTextArea("CODE:");

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
        regPos1 = new JMenuItem("Add Red Space");
        regPos1.addActionListener(this);
        popup.add(regPos1);
        regPos2 = new JMenuItem("Add Magenta Space");
        regPos2.addActionListener(this);
        popup.add(regPos2);

        generateCode = new Button("Generate Code");
        generateCode.addActionListener(this);
        add(generateCode);
        generateCode.setBounds(WIDTH/2-60, 405, 130, 30);
        pieceThere = new Boolean[8][8];
        for(int row=0; row<8; row++)
        {
            for(int col=0; col<8; col++)
            {
                pieceThere[row][col]=false;
            }
        }

        addMouseListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == king)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(pieceThere[xPos/50][yPos/50]==false)
                pieces.add(new King(xPos,yPos));
            pieceThere[xPos/50][yPos/50]=true;
            repaint();        
        }
        if (ae.getSource() == queen)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(pieceThere[xPos/50][yPos/50]==false)
                pieces.add(new Queen(xPos,yPos));
            pieceThere[xPos/50][yPos/50]=true;
            repaint();   
        }
        if (ae.getSource() == knight)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(pieceThere[xPos/50][yPos/50]==false)
                pieces.add(new Knight(xPos,yPos));
            pieceThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if (ae.getSource() == bishop)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(pieceThere[xPos/50][yPos/50]==false)
                pieces.add(new Bishop(xPos,yPos));
            pieceThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if (ae.getSource() == rook)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY; 
            if(pieceThere[xPos/50][yPos/50]==false)
                pieces.add(new Rook(xPos,yPos));
            pieceThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if (ae.getSource() == finalPos)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            regPoints1.add(new Point(xPos,yPos));
            finalPoints.add(new Point(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == regPos1)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            regPoints1.add(new Point(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == regPos2)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            regPoints2.add(new Point(xPos,yPos));
            repaint();
        }
        if (ae.getSource() == generateCode)
        {
            JFrame frame= new JFrame("Code");
            frame.setPreferredSize(new Dimension(500,500));
            frame.setLayout(null);
            textArea.setText("Code: ");
            for(Piece p: pieces)
            {
                textArea.append(("\n" + "pieces.add(new " + p.getName() + "(" + (int) p.getX()/50 + "," + (int)p.getY()/50 + "));"));
            }
            for(Point p: finalPoints)
            {
                textArea.append(("\n" + "finalLocations.add(new Point(" + (int)p.getX()/50 + "," + (int)p.getY()/50 + "));"));
            }
            for(Point p: regPoints1)
            {
                textArea.append(("\n" + "positions[" + (int)p.getX()/50 + "][" + (int)p.getY()/50 + "]=1;"));
            }
            for(Point p: regPoints2)
            {
                textArea.append(("\n" + "positions[" + (int)p.getX()/50 + "][" + (int)p.getY()/50 + "]=2;"));
            }

            textArea.setBounds(0,0,500,1000);
            frame.add(textArea);

            frame.pack();
            frame.setVisible(true);
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
        for(Point p: regPoints1)
        {
            graphics.setColor(Color.RED);
            graphics.fillRect((int)(p.getX()), (int)(p.getY()),50,50);
        }
        for(Point p: regPoints2)
        {
            graphics.setColor(Color.MAGENTA);
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

        for(Piece p: pieces)
            graphics.drawImage(p.getImage(),p.getX(),p.getY(),this);
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
        king.setVisible(true); 
        queen.setVisible(true);
        rook.setVisible(true);
        knight.setVisible(true);
        bishop.setVisible(true);
        if(pieceThere[(xPos-xPos%50)/50][(yPos-yPos%50)/50])
        {
            king.setVisible(false);
            queen.setVisible(false);
            rook.setVisible(false);
            knight.setVisible(false);
            bishop.setVisible(false);
        }
        if(SwingUtilities.isRightMouseButton(e))
        {

            popup.show(e.getComponent(), e.getX(), e.getY());
        }

    }
}
