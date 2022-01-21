package rssNewsBias;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * The Audio program plays music from a Url. It has only been tested
 * to use .wav files.
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class Audio {
    /**
     * This method takes in the Url of the .wav file and plays the file.
     * 
     * @param filePath  This is the Url of the audio file
     */
    //https://youtu.be/TErboGLHZGA
    public void playMusic(String filePath){
        try{
            //http://www.java2s.com/Code/Java/Development-Class/LoadaudiofileFromURL.htm
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
