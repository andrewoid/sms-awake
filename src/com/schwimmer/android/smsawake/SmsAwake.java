package com.schwimmer.android.smsawake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsAwake extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, final Intent intent) {
		final Intent i = new Intent();
		i.setClass(context, SmsAwakeService.class);
		context.startService(i);
	}

}
