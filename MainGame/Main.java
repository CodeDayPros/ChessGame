import javax.swing.JFrame;
import java.applet.Applet;
import java.awt.event.*;

public class Main
{
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        final Applet applet = new GUI();
        frame.setSize(418, 486);

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
