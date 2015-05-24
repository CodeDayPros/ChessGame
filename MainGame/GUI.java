
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
    Button retryButton;
    final int WIDTH = 400;
    final int HEIGHT = 430;
    Board board;
    LevelGenerator generator;

    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        graphics = image.getGraphics();
        generator = new LevelGenerator();
        board = generator.nextLevel();
        this.setLayout(null);
        this.resize(WIDTH,HEIGHT);
        addMouseListener(this);

        retryButton = new Button("Retry Level!");
        retryButton.addActionListener(this);
        add(retryButton);
        retryButton.setBounds(WIDTH-80, 405, 75, 25);

        int delay = 20; //milliseconds
        ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    if (board.getState() == BoardState.WON)
                        board = generator.nextLevel();
                    else if (board.getState() == BoardState.LOST)
                        board = generator.restartLevel();
                    repaint();
                }
            };
        new Timer(delay, taskPerformer).start();
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == retryButton)
        {
            board = generator.restartLevel();
        }
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {      
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        board.drawBoard(graphics);
        graphics.setColor(Color.BLACK);
        graphics.drawString("Level " + generator.getCurrentLevel(), 5, 420);
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

