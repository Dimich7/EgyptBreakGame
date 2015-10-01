package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dima on 24/05/2015.
 */
public class Menu extends JFrame {
    JButton b1;
    JButton b2;
    EventHandler e=new EventHandler();
    Drawing drawing=new Drawing();

    public Menu(String s){
        super(s);
        //setLayout(new FlowLayout());
        //setLayout(new BorderLayout());
        b1=new JButton("Start Game");
        b2=new JButton("Exit Game ");
        getContentPane().add(BorderLayout.NORTH,b1);

        getContentPane().add(BorderLayout.SOUTH,b2);
        getContentPane().add(BorderLayout.CENTER,drawing);

        b1.setPreferredSize(new Dimension(110, 45));
        b2.setPreferredSize(new Dimension(110, 45));

        b2.addActionListener(e);
        b1.addActionListener(e);

    }

    public class Drawing extends JPanel{
        public  void paint(Graphics g){
            Image image=new ImageIcon("Res/Moses.png").getImage();
            g.drawImage(image, 0, 0, this);
        }
    }


    public class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==b2){
                System.exit(1);
            }
            if (e.getSource()==b1){
                Main.mainMethod();
            }
        }
    }
}
