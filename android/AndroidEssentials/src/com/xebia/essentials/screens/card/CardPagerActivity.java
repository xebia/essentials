package com.xebia.essentials.screens.card;

import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.model.Category;
import com.xebia.essentials.screens.card.CardFragment.CardFragmentListener;
import com.xebia.essentials.general.CardApplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class CardPagerActivity extends SherlockFragmentActivity implements CardFragmentListener {
	private static final String LOG_TAG = CardPagerActivity.class.getName();
    
	
	public static void start( Context context, Card card ) {
		
		Preconditions.checkArgument(card != null);
		
		Log.i(LOG_TAG, "Launch for card:"+ card.toString() );
		
		Intent intent = new Intent(context, CardPagerActivity.class);
		intent.putExtra("title", card.getTitle() );
	    context.startActivity(intent);
	}
		
	private Card getCurrentCard( CardStoreI cardStore ) {
		Card currentCard = null;
		
		String title = getTitleFromStartupIntent( getIntent() );
		if( title != null ) {
			currentCard = cardStore.getCardOnTitle(title);
		}
		
		return currentCard;
	}
	
	private boolean isStartedFromWeb( Intent intent ) {
		return intent.getData() != null;
	}
	
	private String getTitleFromStartupIntent( Intent intent ) {
		String title = null;
		
	    if( intent != null ) {
	    	
			title = intent.getStringExtra("title");
			if( title != null ) {
				
				/*
				 * Started from parent activity
				 */
				
			} else {
				
				/* 
				 * Started up from url 
				 * with first segment card-name?
				 */
				Uri data = intent.getData();
				if( data != null ) {
					List<String> params = data.getPathSegments();
					if( params.size() > 0 ) {
						title = params.get(0);
					}

				}
			}
	    }
		
	    return title;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(LOG_TAG, "onCreate" );

		setContentView(R.layout.card_swipe_fragment);
		
		/*
		 * Determine if upper left must be back button
		 */
        getSupportActionBar().setHomeButtonEnabled(true);
        if( isStartedFromWeb(getIntent()) ) {
        	getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
        	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
	
		CardStoreI cardStore = ((CardApplication)getApplication()).getCardStore();
		List<Card> cards = cardStore.getCardsOnCategory(Category.any);
		
		CardAdapter adapter = new CardAdapter(getSupportFragmentManager(), cards);

		ViewPager pager = (ViewPager) findViewById(R.id.cardpager);
		pager.setAdapter(adapter);
		pager.requestDisallowInterceptTouchEvent(true);

		Card card = getCurrentCard( cardStore );
		if( card == null ) {
			/*
			 * Start from beginning
			 */
			pager.setCurrentItem( 0 );
			
		} else {
			/*
			 * Start with specific card
			 */
			pager.setCurrentItem( card.getIndex() );
		}		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		Log.i(LOG_TAG,  "onResume:" );
	}
	
	@Override
	public void onPause() {
		super.onPause();
    	Log.i(LOG_TAG,  "onPause:" );
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
    	Log.i(LOG_TAG,  "onDestroy:" );
	}
	
	@Override
    public void onWebPageSelected( Card card ) {
    	if( card != null ) {
    		Log.i(LOG_TAG, "Visit web-page:" + card.getTitle() );
    		CardDetailsActivity.start(this, card);
    	}
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean status = true;

	   if( item.getItemId() == android.R.id.home ) {
	       this.finish();
	   } else {
		   return super.onOptionsItemSelected(item);
	   }
	   
	   return status;
	}


}
