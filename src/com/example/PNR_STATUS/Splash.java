package com.example.PNR_STATUS;

import com.example.checkyourpnrstatus.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{ // we create activity to join two screen view each part of app hav different activity

	MediaPlayer bgsong; // declaring global variable so used i whole class
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { // class
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		MediaPlayer bgsong = MediaPlayer.create(Splash.this,R.raw.bgmusic );
		bgsong.start();
		Thread timer = new Thread(){
			public void run(){// method
				try{
					sleep(6000); //sleep for 5 sec
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
			//	Intent openMainpoint = new Intent("com.example.checkyourpnrstatus.MAINACTIVITY");
				startActivity(new Intent(Splash.this,Menu.class));
				//MainActivity(openMainpoint);				
				}
			}

		};
		
		timer.start();
	}

	@Override
	protected void onPause() { // this method kills splash activity
		 //TODO Auto-generated method stub
		super.onPause();
	//	bgsong.pause();// ends song when activity ends
		finish();
	}
}
