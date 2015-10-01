package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dima on 08/05/2015.
 */
public class Player {
    public static final int MAX_V=50;
    public static final int MAX_TOP=100;
    public static final int MAX_BOTTOM=540;


    Image player_c=new ImageIcon("Res/merkava.png").getImage();
    Image player_up=new ImageIcon("Res/merkava_up.png").getImage();
    Image player_down=new ImageIcon("Res/merkava_down.png").getImage();
    Image player=player_c;

    public Rectangle getRect(){
        return new Rectangle(x,y,210,110);
    }
    int v=0;
    int s=0;
    int sv=0;

    int dy=0;

    int x=100;
    int y=490;
    int layer1=0;
    int layer2=1200;

    public void move(){
        s+=v;
        v+=sv;
        if (v<=0)v=0;
        if (v>=MAX_V)v=MAX_V;
        y-=dy;
        if (y<=MAX_TOP)y=MAX_TOP;
        if (y>=MAX_BOTTOM)y=MAX_BOTTOM;
        if (layer2-v<=0){
            layer1=0;
            layer2=1199;
        }
        else {
            layer1 -= v;
            layer2 -= v;
        }
    }

    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_RIGHT){
            sv=1;
        }
        if (key==KeyEvent.VK_LEFT){
            sv=-1;
        }
        if (key==KeyEvent.VK_UP){
            dy=10;
            player=player_up;
        }
        if (key==KeyEvent.VK_DOWN){
            dy=-10;
            player=player_down;
        }
    }
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_LEFT){
            sv=0;
        }
        if (key==KeyEvent.VK_UP || key==KeyEvent.VK_DOWN){
            dy=0;
            player=player_c;
        }
    }

}
