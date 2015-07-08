
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
    Button finishButton;
    Button startButton;
    Button instructionButton;
    Button selectLevel;
    final int WIDTH = 400;
    final int HEIGHT = 435;
    Board board;
    LevelGenerator generator;
    Boolean levelScreen;

    public void init()
    { 
        image = createImage(WIDTH,HEIGHT);
        levelScreen=false;

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
        add(nextLevelButton);
        nextLevelButton.setBounds(WIDTH/2-40, 200, 80, 30);
        nextLevelButton.setVisible(false);

        finishButton = new Button("Finish");
        finishButton.addActionListener(this);
        add(finishButton);
        finishButton.setBounds(WIDTH/2-40, 200, 80, 30);
        finishButton.setVisible(false);

        startButton = new Button("Start Game");
        startButton.addActionListener(this);
        add(startButton);
        startButton.setBounds(WIDTH/2-40, 320, 80, 30);

        instructionButton = new Button("Instructions");
        instructionButton.addActionListener(this);
        add(instructionButton);
        instructionButton.setBounds(WIDTH/2-40, 355, 80, 30);

        selectLevel= new Button("Select Level");
        selectLevel.addActionListener(this);
        add(selectLevel);
        selectLevel.setBounds(WIDTH/2-40, 390, 80, 30);

        int delay = 20; //milliseconds
        ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    if (board != null && board.getState() == BoardState.WON)
                    {
                        if (generator.getCurrentLevel() == generator.getNumLevels())
                            finishButton.setVisible(true);
                        else
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
        if (ae.getSource() == finishButton)
        {
            generator.resetGame();
            board = null;
            retryButton.setVisible(false);
            startButton.setVisible(true);
            instructionButton.setVisible(true);
            selectLevel.setVisible(false);
            finishButton.setVisible(false);
        }
        if (ae.getSource() == startButton)
        {
            board = generator.nextLevel();
            startButton.setVisible(false);
            instructionButton.setVisible(false);
            retryButton.setVisible(true);
            selectLevel.setVisible(true);
            selectLevel.setBounds(WIDTH/2+30, 405, 80, 30);
        }
        if (ae.getSource() == instructionButton)
        {
            //show instructions
            JFrame frame= new JFrame("Instructions");
            frame.setPreferredSize(new Dimension(550,250));
            frame.setLayout(null);

            JLabel label = new JLabel("<html>The goal of this game is to move the chess pieces into the dashed squares by " + 
                    "first going through the highlighted spaces. " + 
                    "Red squares need to be visited once while purple squares need to be visited twice. " +
                    "Click on a piece to select it and click on an outlined square to move the piece to that square." +
                    "<br><br>The pieces are as follows: Knights, Rooks, Bishops, Queens and Kings." +
                    "<br>Knights move in an L while jumping over other pieces. For example, they can move up 1 and left 2 or down 2 and right 1." +
                    "<br>Rooks move in straight lines." + 
                    "<br>Bishops move in diagonals." + 
                    "<br>Queens can move in straight lines or diagonals." +
                    "<br>Kings can move to any directly adjacent space." +
                    "</html>");
            label.setBounds(0,0,500,200);

            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        }
        if(ae.getSource() == selectLevel)
        {
            levelScreen=true;
            startButton.setVisible(false);
            instructionButton.setVisible(false);
            selectLevel.setVisible(false);
            retryButton.setVisible(false);
            generator.setLevel(0);
        }
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {      
        if (graphics != null && generator != null)
        {
            graphics.clearRect(0, 0, WIDTH, HEIGHT);
            if(levelScreen)
            {
                boolean drawNumber=true;
                int i=1;
                graphics.setFont(new Font("Arial", Font.BOLD, 16));
                for (int col = 0; col < 8; col++)
                {
                    for (int row = 0; row < 8; row++)
                    {
                        if ((row + col) % 2 == 0)
                            graphics.setColor(new Color(150, 150, 150));
                        else
                            graphics.setColor(new Color(120, 120, 120));
                        graphics.fillRect(row*50,col*50,50,50);
                        graphics.setColor(Color.BLACK);
                        graphics.drawRect(row*50, col*50, 50, 50);
                        if(i>generator.getNumLevels())
                            drawNumber=false;
                        if(drawNumber)
                        {
                            graphics.setColor(Color.RED);
                            graphics.fillOval(row*50,col*50,50,50);        
                            String number = "" + i;
                            graphics.setColor(Color.BLUE);
                            if(i<10)
                                graphics.drawString(number,row*50 + 21,col*50 + 31);
                            else
                                graphics.drawString(number,row*50 + 16,col*50 + 31);
                            i++;
                        }
                    }
                }

            }
            else if (generator.getCurrentLevel() > 0)
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
        }
        g.drawImage(image, 0, 0, this);
    }

    public void mousePressed(MouseEvent e) {
        int xPos= e.getX();
        int yPos= e.getY();

        if(generator.getCurrentLevel()>0)
            board.clickOnBoard(xPos, yPos);
        else if (levelScreen)
        {
            int i=0;         
            outerLoop:
            for(int row=0; row<8; row++)
            {
                for(int col=0; col<8; col++)
                {

                    if(xPos > col*50
                    && xPos < col*50 + 50
                    && yPos > row*50 
                    && yPos < row*50+50)
                    {
                        if (i < generator.getNumLevels())
                        {
                            generator.setLevel(i);
                            board = generator.nextLevel();
                            retryButton.setVisible(true);
                            selectLevel.setVisible(true);
                            selectLevel.setBounds(WIDTH/2+30, 405, 80, 30);
                            levelScreen = false;
                        }
                        break outerLoop;
                    }
                    i++;
                }
            }
        }

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }
}

