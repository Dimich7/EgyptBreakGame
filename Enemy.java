package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 15/05/2015.
 */
public class Enemy {
    int x;
    int y;
    int v;
    Image img=new ImageIcon("Res/merkava_egypt.png").getImage();
    Road road;

    public Rectangle getRect(){
        return new Rectangle(x,y,160,105);
    }
    public Enemy(int x,int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move(){
        x=x-road.p.v+v;
    }
}
