package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

public class Sound {

    Clip clip;
    public File[] soundURL = new File[30];

    public Sound() {
        soundURL[0] = new File("src/tunes/worldMusic/World.wav");
        soundURL[1] = new File("src/tunes/worldSoundEffects/key.wav");
        soundURL[2] = new File("src/tunes/worldSoundEffects/chest.wav");
        soundURL[3] = new File("src/tunes/worldSoundEffects/door.wav");
        soundURL[4] = new File("src/tunes/worldMusic/fight.wav");
        soundURL[5] = new File("src/tunes/battleSoundEffects/attack.wav");
        soundURL[6] = new File("src/tunes/battleSoundEffects/hit.wav");
        soundURL[7] = new File("src/tunes/battleSoundEffects/menu.wav");
        soundURL[8] = new File("src/tunes/battleSoundEffects/fireball.wav");

    }

    public void setFile(int index) {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[index]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e){

        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
