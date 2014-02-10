package com.xebia.essentials.screens.main;

import nl.ideal.app.rabobank.AppCapabilitiesStore;
import nl.ideal.app.rabobank.AppCapabilitiesStoreI;
import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.general.CardApplication;
import com.xebia.essentials.screens.card.CardDetailsActivity;
import com.xebia.essentials.screens.card.CardPagerActivity;
import com.xebia.essentials.screens.card.CardFragment;
import com.xebia.essentials.screens.deck.CardListFragment;

public class MainActivity extends SherlockFragmentActivity implements CardFragment.CardFragmentListener,CardListFragment.CardListFragmentListener {
	private static final String LOG_TAG = MainActivity.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        
		AppCapabilitiesStoreI store = new AppCapabilitiesStore( this.getApplicationContext() );
		store.setAppReadyToPay( true );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add("Random").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		menu.add("About").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean status = true;

		if (item.getTitle().equals("Random")) {
			CardStoreI store = ((CardApplication)getApplication()).getCardStore();
			Card card = store.getRandomCard();
			CardPagerActivity.start(this, card);
		} else if (item.getTitle().equals("About")) {
			WebActivity.start(this, "file:///android_asset/about.html");
		} else {
			return super.onOptionsItemSelected(item);
		}

		return status;
	}
	
	@Override
	public void onCardSelected(Card card) {
    	if( card != null ) {
    		Log.i(LOG_TAG, "Visit web-page:" + card.getTitle() );
    		
    		 CardFragment cardFrag = (CardFragment)getSupportFragmentManager().findFragmentById(R.id.card_fragment);
    		 if (cardFrag == null  || cardFrag.isInLayout() == false ) {
    			 
    			 /*
    			  * Start dedicated activity
    			  */
    	    	 CardPagerActivity.start(this, card);

    		 } else {
    			
    			 cardFrag.updateCard( card );
    		 }
    	}
	}

	@Override
    public void onWebPageSelected( Card card ) {
    	if( card != null ) {
    		Log.i(LOG_TAG, "Visit web-page:" + card.getTitle() );
    		CardDetailsActivity.start(this, card);
    	}
    }

}
