package com.schwimmer.android.smsawake;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;

public class SmsAwakeService extends Service implements Runnable {

	private Handler handler;
	private WakeLock wakeLock;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
		wakeLock = pm.newWakeLock(
				PowerManager.ACQUIRE_CAUSES_WAKEUP | 
				PowerManager.SCREEN_BRIGHT_WAKE_LOCK,
				"SmsAwake");
		
		wakeLock.acquire();
		
		handler = new Handler();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		int delay  = Integer.parseInt( prefs.getString("timeout", "5") ) * 1000;
		
		handler.postDelayed(this, delay);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		wakeLock.release();
		this.stopSelf();
	}
	
	

}
