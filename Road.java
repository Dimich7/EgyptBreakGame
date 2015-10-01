package Main;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Dima on 08/05/2015.
 */
public class Road extends JPanel implements ActionListener,Runnable {

    Timer mainTimer=new Timer(20,this);

    Image image=new ImageIcon("Res/road.png").getImage();
    Player p=new Player();

    Thread enemiesFactory=new Thread(this);
    Thread audioThread=new Thread(new AudioThread());

    List<Enemy>enemies=new ArrayList<Enemy>();

    public Road(){
        mainTimer.start();
        enemiesFactory.start();
        audioThread.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void run() {
        while (true){
            Random rand=new Random();
            try {
                Thread.sleep(rand.nextInt(1500));
                enemies.add(new Enemy(2000,rand.nextInt(600),rand.nextInt(35),this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g){
        g=(Graphics2D)g;
        g.drawImage(image,p.layer1,0,null);
        g.drawImage(image,p.layer2,0,null);
        g.drawImage(p.player,p.x,p.y,null);

        Iterator<Enemy>i=enemies.iterator();
        while (i.hasNext()){
            Enemy e=i.next();
            if (e.x>=2400||e.x<=-2400){
                i.remove();
            }else {
                e.move();
                g.drawImage(e.img, e.x, e.y, null);
            }
        }

    }

    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
        testCollisionWithEnemies();
        testWin();

    }

    private void testWin() {   //Need win window
        if (p.s>30000){
            WinWindow.mainWinWindow();
            JOptionPane.showMessageDialog(null,"Congratulations!\nYou win!");
            System.exit(0);
        }

    }

    private void testCollisionWithEnemies(){    //Need L=loose window
        Iterator<Enemy>i=enemies.iterator();
        while (i.hasNext()){
            Enemy e=i.next();
            if (p.getRect().intersects(e.getRect())){
                LoseWindow.loseWindow();
                JOptionPane.showMessageDialog(null, "You lose!!!");
                System.exit(1);
            }
        }
    }
}
