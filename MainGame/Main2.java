
import javax.swing.JFrame;
import java.applet.Applet;
import java.awt.event.*;

public class Main2 // for copy/paste funconality bc apparently java applets cannot copy to system clipboard (which is stupid)
{
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        final Applet applet = new LevelMaker();
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