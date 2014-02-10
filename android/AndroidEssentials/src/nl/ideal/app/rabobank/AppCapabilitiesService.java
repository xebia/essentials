package nl.ideal.app.rabobank;

import nl.ideal.app.AppCapabilitiesServiceI;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AppCapabilitiesService extends Service {
	private static final String LOG_TAG = AppCapabilitiesService.class.getName();

	private Context appContext = null;

	@Override
	public void onCreate() {
		super.onCreate();
		
		this.appContext = this.getApplicationContext();
		
		Log.i(LOG_TAG, "onCreate" );
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(LOG_TAG, "onBind:"+ intent.toString() );
		return mBinder;
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		Log.i(LOG_TAG, "onRebind:"+ intent.toString() );
	}

	private final AppCapabilitiesServiceI.Stub mBinder = new AppCapabilitiesServiceI.Stub() {
		@Override
		public boolean isReadyToPay() {
			
			/*
			 * Fetch app-status from local persistent store
			 */
			AppCapabilitiesStoreI store = new AppCapabilitiesStore(appContext);
			boolean readyToPay =  store.isAppReadyToPay();

			Log.i(LOG_TAG, "isReadyToPay:" + readyToPay );
			
			return readyToPay;
		}

	};

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(LOG_TAG, "onUnbind:"+ intent.toString() );
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(LOG_TAG, "onDestroy" );
	}
}
