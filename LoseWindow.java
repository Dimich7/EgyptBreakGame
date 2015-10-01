package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 22/06/2015.
 */
public class LoseWindow extends JPanel {
    Image image=new ImageIcon("Res/Rab.jpg").getImage();

    public  static void loseWindow(){
        JFrame frame=new JFrame("Lose!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.add(new LoseWindow());
    }

    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }
}
