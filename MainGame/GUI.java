
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
    Image titleImage;
    Button retryButton;
    Button nextLevelButton;
    Button startButton;
    Button instructionButton;
    final int WIDTH = 400;
    final int HEIGHT = 435;
    Board board;
    LevelGenerator generator;

    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        try 
        {
            titleImage = ImageIO.read(new File("butter.png"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        graphics = image.getGraphics();
        generator = new LevelGenerator();
        this.setLayout(null);
        this.resize(WIDTH,HEIGHT);
        addMouseListener(this);

        retryButton = new Button("Retry Level");
        retryButton.addActionListener(this);
        retryButton.setVisible(false);
        add(retryButton);
        retryButton.setBounds(WIDTH-85, 405, 80, 30);

        nextLevelButton = new Button("Next Level");
        nextLevelButton.addActionListener(this);
        nextLevelButton.setVisible(false);
        add(nextLevelButton);
        nextLevelButton.setBounds(WIDTH/2-40, 200, 80, 30);

        startButton = new Button("Start Game");
        startButton.addActionListener(this);
        add(startButton);
        startButton.setBounds(WIDTH/2-40, 320, 80, 30);
        
        instructionButton = new Button("Instructions");
        instructionButton.addActionListener(this);
        add(instructionButton);
        instructionButton.setBounds(WIDTH/2-40, 355, 80, 30);

        int delay = 20; //milliseconds
        ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    if (board != null && board.getState() == BoardState.WON)
                    {
                        nextLevelButton.setVisible(true);
                        retryButton.setEnabled(false);
                    }
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
        if (ae.getSource() == nextLevelButton)
        {
            board = generator.nextLevel();
            nextLevelButton.setVisible(false);
            retryButton.setEnabled(true);
        }
        if (ae.getSource() == startButton)
        {
            board = generator.nextLevel();
            startButton.setVisible(false);
            instructionButton.setVisible(false);
            retryButton.setVisible(true);
        }
        if (ae.getSource() == instructionButton)
        {
            //show instructions
        }
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {      
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        if (generator.getCurrentLevel() > 0)
        {
            board.drawBoard(graphics);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial", Font.BOLD, 16));
            graphics.drawString("Level " + generator.getCurrentLevel(), 5, 425);
            if (board.getState() == BoardState.WON)
            {
                graphics.setColor(new Color(255, 255, 255, 200));
                graphics.fillRect(WIDTH/2-100, 165, 200, 70);
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial", Font.BOLD, 20));
                graphics.drawString("You Win!", WIDTH/2-42, 190);
            }
            else if (board.getState() == BoardState.LOST)
            {
                graphics.setColor(new Color(255, 255, 255, 200));
                graphics.fillRect(WIDTH/2-100, 185, 200, 30);
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial", Font.BOLD, 20));
                graphics.drawString("You Lost!", WIDTH/2-45, 207);
            }
        }
        else
            graphics.drawImage(titleImage, 50, 75, 300, 200, null);
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

