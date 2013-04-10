package com.example.lejosbluetooth;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool;


public class SoundPlayer {

	public static enum Sound
	{
	
		S1(R.raw.adios);
		int resId;
		
		Sound(int id)
		{
		  this.resId = id;	
		}
	}
	
	private static SoundPlayer sp;
	private SoundPool soundPool;
	private Context context;
	private MediaPlayer mp;
	private HashMap<Sound, Integer> soundPoolMap;	
	private SoundPlayer()
	{
	}
	
	public void init(Context context)
	{
		this.context = context;
		
		if(soundPool == null)
		{
			soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
			soundPoolMap = new HashMap<Sound,Integer>(1);
			soundPoolMap.put(Sound.S1  , soundPool.load(context, R.raw.ping, 1));
		}
	}
	public static SoundPlayer singleton()
	{
		if(sp == null)
		{
			sp = new SoundPlayer();
		}
		
		return sp;
	}
	
	public void playSound(Sound sound_id)
	{
		if(context ==null)return;

		if(mp == null || !mp.isPlaying())
		{
			mp = MediaPlayer.create(context, R.raw.ping);
			mp.start();
		}
		
		
		
		//currently not using soundpool because you can't tell when it has finished playing the sound
//  	    soundPool.play(soundPoolMap.get(sound_id), 1, 1, 1, 0, 1);
		
	}
}
