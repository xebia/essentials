package com.xebia.essentials.screens.main;

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

		// no upper left back-button
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

   	}

	@Override
	public void onResume() {
		super.onResume();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// add prominent button to action-bar shat shows random card
		menu.add("Random").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		// add information button: less prominent
		menu.add("About").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean status = true;

		if (item.getTitle().equals("Random")) {
			/*
			 * Start card-screen with a random card
			 */
			CardStoreI store = ((CardApplication)getApplication()).getCardStore();
			Card card = store.getRandomCard();
			CardPagerActivity.start(this, card);
			
		} else if (item.getTitle().equals("About")) {
			/*
			 * Show on-board html in webview
			 */
			WebActivity.start(this, "file:///android_asset/about.html");
		} else {
			return super.onOptionsItemSelected(item);
		}

		return status;
	}
	
	private CardFragment getCardFragment() {
	
		 CardFragment cardFrag = (CardFragment)getSupportFragmentManager().findFragmentById(R.id.card_fragment);
		 if (cardFrag == null  || cardFrag.isInLayout() == false ) {
			 cardFrag = null;
		 }
		 
		 return cardFrag;
	}
	
	
	@Override
	public void onCardSelected(Card card) {
    	if( card != null ) {
    		Log.i(LOG_TAG, "Visit web-page:" + card.getTitle() );
    		
			 CardFragment cardFrag = getCardFragment();
    		 if( cardFrag == null ) {
    			 
    			 /*
    			  * Start card-screen as dedicated activity on top of previous
    			  */
    	    	 CardPagerActivity.start(this, card);
    	    	 
    		 } else {
    			
    			 /*
    			  * Update fragment in right part of the screen
    			  */
    			 cardFrag.updateCard( card );
    		 }
    	}
	}

	@Override
    public void onWebPageSelected( Card card ) {
		
    	if( card != null ) {
    		Log.i(LOG_TAG, "Visit web-page:" + card.getTitle() );
			 /*
			  * Start card-details as dedicated activity on top of previous
			  */
    		CardDetailsActivity.start(this, card);
    	}
    }

}
