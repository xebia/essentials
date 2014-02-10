package com.xebia.essentials.general;

import java.io.IOException;

import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.general.EssentialsExeception;
import com.xebia.essentials.datastore.FileBasedCardStore;

import android.app.Application;

public class CardApplication extends Application {
	private CardStoreI cardStore = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		try {
			cardStore = new FileBasedCardStore(getAssets().open("index.json"));
		} catch (IOException exc) {
			throw new EssentialsExeception( exc);
		}
	}
	
	public CardStoreI getCardStore() {
		return cardStore;
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
	
	

}
