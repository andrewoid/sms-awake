package com.schwimmer.android.smsawake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsAwake extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent i = new Intent();
		i.setClass(context, SmsAwakeService.class );
		context.startService( i );
	}

}
