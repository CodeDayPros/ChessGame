
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
public class LevelMaker extends Applet implements ActionListener, MouseListener
{
    private JPopupMenu popup;
    private final int WIDTH = 400;
    private final int HEIGHT = 435;
    private JMenuItem king;
    private JMenuItem queen;
    private JMenuItem bishop;
    private JMenuItem knight;
    private JMenuItem rook;
    private JMenuItem finalPos;
    private JMenuItem regPos1;
    private JMenuItem regPos2;
    private JMenuItem remove;
    private Graphics graphics;
    private Image image;

    private Boolean[][] pieceThere;
    private Boolean[][] positionThere;
    private List<Piece> pieces;
    private List<Point> regPoints1;
    private List<Point> regPoints2;
    private List<Point> finalPoints;

    private JTextArea textArea;
    private Button generateCode;
    private Button reset;
    private int xPos;
    private int yPos;
    private String text;
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
        remove = new JMenuItem("Remove");
        remove.addActionListener(this);
        popup.add(remove);

        generateCode = new Button("Generate Code");
        generateCode.addActionListener(this);
        add(generateCode);
        generateCode.setBounds(WIDTH/2+20, 405, 130, 30);
        reset=new Button("Reset");
        reset.addActionListener(this);
        add(reset);
        reset.setBounds(50, 405, 130, 30);

        pieceThere = new Boolean[8][8];
        positionThere = new Boolean[8][8];
        for(int row=0; row<8; row++)
        {
            for(int col=0; col<8; col++)
            {
                pieceThere[row][col]=false;
                positionThere[row][col]=false;
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
            if(positionThere[xPos/50][yPos/50]==false)
            {
                regPoints1.add(new Point(xPos,yPos));
                finalPoints.add(new Point(xPos,yPos));
            }
            positionThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if (ae.getSource() == regPos1)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(positionThere[xPos/50][yPos/50]==false)
                regPoints1.add(new Point(xPos,yPos));
            positionThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if (ae.getSource() == regPos2)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(positionThere[xPos/50][yPos/50]==false)
                regPoints2.add(new Point(xPos,yPos));
            positionThere[xPos/50][yPos/50]=true;
            repaint();
        }
        if(ae.getSource() == remove)
        {
            int roundingX = xPos%50;
            int roundingY = yPos%50;
            xPos-=roundingX;
            yPos-=roundingY;
            if(positionThere[xPos/50][yPos/50]==true)
            {
                for(int i=0; i<regPoints1.size(); i++)
                {
                    int x= (int)regPoints1.get(i).getX();
                    int y= (int)regPoints1.get(i).getY();
                    if(xPos==x && yPos==y)
                    {
                        regPoints1.remove(i);
                        positionThere[xPos/50][yPos/50]=false;
                        break;
                    }
                }
                for(int i=0; i<regPoints2.size(); i++)
                {
                    int x= (int)regPoints2.get(i).getX();
                    int y= (int)regPoints2.get(i).getY();
                    if(xPos==x && yPos==y)
                    {
                        regPoints2.remove(i);
                        positionThere[xPos/50][yPos/50]=false;
                        break;
                    }
                }
                for(int i=0; i<finalPoints.size(); i++)
                {
                    int x= (int)finalPoints.get(i).getX();
                    int y= (int)finalPoints.get(i).getY();
                    if(xPos==x && yPos==y)
                    {
                        finalPoints.remove(i);
                        positionThere[xPos/50][yPos/50]=false;
                        break;
                    }
                }
            }
            if(pieceThere[xPos/50][yPos/50]==true)
            {
                for(int i=0; i<pieces.size(); i++)
                {
                    int x= (int)pieces.get(i).getX();
                    int y= (int)pieces.get(i).getY();
                    if(xPos==x && yPos==y)
                    {
                        pieces.remove(i);
                        pieceThere[xPos/50][yPos/50]=false;
                        break;
                    }
                }
            }
            repaint();
        }
        if (ae.getSource() == generateCode)
        {
            JFrame frame= new JFrame("Code");
            frame.setPreferredSize(new Dimension(500,500));
            frame.setLayout(null);
            textArea.setText("");
            textArea.append("levelsList.add(new Level()" + "\n" +
                "{  \n" +
                "      public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions) \n" +
                "      {");
            for(Piece p: pieces)
            {
                textArea.append(("\n" + "            pieces.add(new " + p.getName() + "(" + (int) p.getX()/50 + "," + (int)p.getY()/50 + "));"));
            }
            for(Point p: finalPoints)
            {
                textArea.append(("\n" + "            finalLocations.add(new Point(" + (int)p.getX()/50 + "," + (int)p.getY()/50 + "));"));
            }  
            for(Point p: regPoints1)
            {
                textArea.append(("\n" + "            positions[" + (int)p.getX()/50 + "][" + (int)p.getY()/50 + "]=1;"));
            }
            for(Point p: regPoints2)
            {
                textArea.append(("\n" + "            positions[" + (int)p.getX()/50 + "][" + (int)p.getY()/50 + "]=2;"));
            }
            textArea.append("} \n });");

            textArea.setBounds(0,0,1000,1000);
            frame.add(textArea);

            frame.pack();
            frame.setVisible(true);
            text = textArea.getText();
            copyStringToClipboard(text);
        }
        if(ae.getSource() == reset)
        {
            regPoints1.clear();
            regPoints2.clear();
            finalPoints.clear();
            pieces.clear();
            for(int row=0; row<8; row++)
            {
                for(int col=0; col<8; col++)
                {
                    pieceThere[row][col]=false;
                    positionThere[row][col]=false;
                }
            }
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
                if ((x + y) % 2 == 0)
                    graphics.setColor(new Color(150, 150, 150));
                else
                    graphics.setColor(new Color(120, 120, 120));
                graphics.fillRect(x*50,y*50,50,50);


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
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                graphics.setColor(Color.BLACK);
                graphics.drawRect(x*50, y*50, 50, 50);

            }
        }

        for(Piece p: pieces)
            graphics.drawImage(p.getImage(),p.getX(),p.getY(),this);
        g.drawImage(image, 0, 0, this);
    }

    public static void copyStringToClipboard(String str) {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
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
        regPos1.setVisible(true);
        regPos2.setVisible(true);
        finalPos.setVisible(true);
        remove.setVisible(false);
        if(pieceThere[(xPos-xPos%50)/50][(yPos-yPos%50)/50])
        {
            king.setVisible(false);
            queen.setVisible(false);
            rook.setVisible(false);
            knight.setVisible(false);
            bishop.setVisible(false);
            remove.setVisible(true);
        }
        if(positionThere[(xPos-xPos%50)/50][(yPos-yPos%50)/50])
        {
            regPos1.setVisible(false);
            regPos2.setVisible(false);
            finalPos.setVisible(false);
            remove.setVisible(true);
        }

        if(SwingUtilities.isRightMouseButton(e))
        {
            popup.show(e.getComponent(), e.getX(), e.getY());
        }

    }
}
