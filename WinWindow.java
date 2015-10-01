package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 13/06/2015.
 */
public class WinWindow extends JPanel {

    Image image=new ImageIcon("Res/getTora.jpg").getImage();

    public static void mainWinWindow() {
        JFrame frame = new JFrame("Congratulations!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 850);
        frame.setVisible(true);
        frame.add(new WinWindow());
    }

    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }
}
