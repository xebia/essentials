package nl.ideal.app.rabobank;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class AppCapabilitiesStore implements AppCapabilitiesStoreI {
	private static String READY_TO_PAY = "nl.ideal.app.rabobank.readyToPay";

	private SharedPreferences prefs = null;
	
	@SuppressWarnings("unused")
	private AppCapabilitiesStore() {}
	
	public AppCapabilitiesStore(Context context) {
		//prefs = context.getSharedPreferences("AppInUse", Context.MODE_PRIVATE);
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
	}

	@Override
	public void setAppReadyToPay( boolean inUse ) {
		Editor edit = prefs.edit();
		edit.putBoolean(READY_TO_PAY, inUse);
		edit.apply(); 
	}
	
	@Override
	public boolean isAppReadyToPay() {
		return prefs.getBoolean(READY_TO_PAY, false);
	}
}
