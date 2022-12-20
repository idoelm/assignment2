package game;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


class MusicPlayer extends Thread {
	  private String filePath;
	  
	  public MusicPlayer(String filePath) {
	    this.filePath = filePath;

	  }

	  @Override
	  public void run() {
		try 
	    {
	      Clip clip = AudioSystem.getClip();
	      clip.open(AudioSystem.getAudioInputStream(new File(this.filePath)));
	      clip.start();
	      Thread.sleep(clip.getMicrosecondLength() / 1000);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
	}
