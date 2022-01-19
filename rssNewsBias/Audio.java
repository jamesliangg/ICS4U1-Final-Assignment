package rssNewsBias;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Audio {
    //https://youtu.be/TErboGLHZGA
    public void playMusic(String filePath){
        try{
            File musicPath = new File(filePath);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                JOptionPane.showMessageDialog(null, "Now playing audio");
            }
            else{
                System.out.println("Can't find file");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
