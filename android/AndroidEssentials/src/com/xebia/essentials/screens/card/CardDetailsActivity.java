package com.xebia.essentials.screens.card;

import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.general.CardApplication;
import com.xebia.essentials.model.Card;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class CardDetailsActivity extends Activity {
	private static final String LOG_TAG = CardDetailsActivity.class.getName();

	public static void start( Context context, Card card ) {
	Preconditions.checkArgument(card != null);
		
		Log.i(LOG_TAG, "Launch for card:"+ card.toString() );
		
		Intent intent = new Intent(context, CardDetailsActivity.class);
		intent.putExtra("title", card.getTitle() );
	    context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.card_details_activity);
		
		WebView webView = (WebView) findViewById(R.id.card_details_webview_id);		

		Intent intent = getIntent();
		if( intent != null ) {
			String title = intent.getStringExtra("title");
			if( title != null ) {
				CardStoreI cardStore = ((CardApplication)getApplication()).getCardStore();
				Card card = cardStore.getCardOnTitle(title);
				//webView.loadUrl("http://www.google.com/search?q="+ card.getTitle() );
				webView.loadUrl("http://essentials.xebia.com/" + card.getTitle() );
			}
		}

	}
	

}
