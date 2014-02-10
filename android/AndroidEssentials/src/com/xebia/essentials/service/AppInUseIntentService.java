package com.xebia.essentials.service;

import nl.ideal.app.rabobank.AppCapabilitiesStore;
import nl.ideal.app.rabobank.AppCapabilitiesStoreI;
import android.app.IntentService;
import android.content.Intent;

public class AppInUseIntentService extends IntentService {
	public static String IN_USE_COMMAND = "com.xebia.essentials.AppInUse";

	public AppInUseIntentService( ) {
		super(AppInUseIntentService.class.getSimpleName() );
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		
		/*
		 * Read local preference
		 */
		AppCapabilitiesStoreI store = new AppCapabilitiesStore( this.getApplicationContext() );
		boolean appInUse = store.isAppReadyToPay();

		/*
		 * Broadcast result back to caller
		 */
		Intent broadcastIntent = new Intent();
		broadcastIntent.setAction(IN_USE_COMMAND);
		broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		broadcastIntent.putExtra(IN_USE_COMMAND, appInUse);
		sendBroadcast(broadcastIntent);
	}

}
