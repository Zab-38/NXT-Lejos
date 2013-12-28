package sound;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlaySound {

	AudioPlayer ap = AudioPlayer.player;

	public void playsound() {
		AudioStream audioStream = null;
		try {
			
			InputStream is  = new FileInputStream("C:/Users/FPNMB/git/NXT-Lejos/YO/src/sound/Offenbach.wav");
			audioStream = new AudioStream(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AudioPlayer.player.start(audioStream);

	}
	public static void main(String[] args) {
		PlaySound play = new PlaySound();
		play.playsound();
	}
}
