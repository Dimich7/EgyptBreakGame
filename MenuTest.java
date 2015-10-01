package Main;

import javax.swing.*;

/**
 * Created by Dima on 24/05/2015.
 */
public class MenuTest {
    public static void main(String[] args) {
        Menu menu=new Menu("Game Menu");
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(384, 537);
        menu.setResizable(false);
    }
}
