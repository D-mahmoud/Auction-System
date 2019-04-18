/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionSystem;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**

 * @author Muhamed Akram
 */
public class Audio {
 
    public void music1(){
{ 

  try
  {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(new File("/Users/tr/Desktop/Auction/cash.wav")));
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
      clip.loop(0);
      

  }
  catch (Exception exc)
  {
      exc.printStackTrace(System.out);
  }
}
}
    

public void music(){
{ 

  try
  {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(new File("/Users/tr/Downloads/Cash Register Cha Ching-SoundBible.com-184076484.wav")));
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
      clip.loop(0);
      

  }
  catch (Exception exc)
  {
      exc.printStackTrace(System.out);
  }
}
}
}