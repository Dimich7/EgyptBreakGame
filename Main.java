package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 08/05/2015.
 */
public class Main {
    public static void mainMethod() {
        JFrame frame=new JFrame("Escape from Egypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150,760);
        frame.add(new Road());
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
