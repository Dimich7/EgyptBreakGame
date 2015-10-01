package Main;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Dima on 24/05/2015.
 */
public class AudioThread implements Runnable {
    public void run(){
        try {
            Player p=new Player(new FileInputStream(getClass().getClassLoader().getResource("Res/MainTheme.mp3").getPath()));
            p.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
