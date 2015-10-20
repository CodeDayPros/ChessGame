
import javax.swing.JFrame;
import java.applet.Applet;
import java.awt.event.*;
import java.util.Scanner;
public class Main3
{
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("How many Knights?");
        int knights = scan.nextInt();
        System.out.println("How many Kings?");
        int kings = scan.nextInt();
        System.out.println("How many Bishops?");
        int bishops = scan.nextInt();
        System.out.println("How many Rooks?");
        int rooks = scan.nextInt();
        System.out.println("How many Queens?");
        int queens = scan.nextInt();
        
        JFrame frame = new JFrame();
        final Applet applet = new randomLevelGenerator(knights, bishops, kings, rooks, queens);
        frame.setSize(430, 550);

        frame.getContentPane().add(applet);
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    applet.stop();
                    applet.destroy();
                    System.exit(0);
                }
            });

        frame.setVisible(true);
        applet.init();
        applet.start();
    }
}
