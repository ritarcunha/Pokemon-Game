package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;

    URL soundURL[]=new URL[10];

    public Sound(){
        soundURL[0]=getClass().getResource("/Sound/town1.wav");
        soundURL[1]=getClass().getResource("/Sound/town1.wav");
    }

    public void setFile(int i){
        try {

            AudioInputStream ais= AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
            System.out.println("caquinha musical");
        }catch (Exception e){
            System.out.println("coco");
        }

    }

    public void play(){
        clip.start();

    }

    public void loop(){

        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
    clip.stop();
    }
}
