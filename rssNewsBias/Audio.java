package rssNewsBias;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Audio {
    //https://youtu.be/TErboGLHZGA
    public void playMusic(String filePath){
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new URL(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            JOptionPane.showMessageDialog(null, "Now playing audio");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
