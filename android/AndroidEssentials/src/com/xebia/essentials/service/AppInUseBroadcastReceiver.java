package com.xebia.essentials.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AppInUseBroadcastReceiver extends BroadcastReceiver {
	private static final String LOG_TAG = AppInUseBroadcastReceiver.class.getName();

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		
		Log.i(LOG_TAG, "Received " + intent.toString() );

		if (action.equals(AppInUseIntentService.IN_USE_COMMAND)) {
			
			Intent asyncServiceIntent = new Intent(context, AppInUseIntentService.class);
			context.startService( asyncServiceIntent );
			
		} else {
			Log.v(LOG_TAG, "Unrecognized action " + action);
		}
	}

}
