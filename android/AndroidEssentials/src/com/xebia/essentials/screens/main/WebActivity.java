package com.xebia.essentials.screens.main;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.common.base.Preconditions;
import com.xebia.essentials.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebActivity extends SherlockActivity {
	private static final String LOG_TAG = WebActivity.class.getName();

	public static void start( Context context, String url ) {
		Preconditions.checkArgument(context != null);
		Preconditions.checkArgument(url != null);
		
		Log.i(LOG_TAG, "Launch with url:"+ url );
		
		Intent intent = new Intent(context, WebActivity.class);
		intent.putExtra("url", url );
	    context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.web_activity);
		
		overridePendingTransition(R.anim.slide_up, R.anim.hold);		
		
		
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

		WebView webView = (WebView) findViewById(R.id.web_activity_webview_id);		

		Intent intent = getIntent();
		if( intent != null ) {
			String url = intent.getStringExtra("url");
			if( url != null ) {
				webView.loadUrl( url );
			}
		}

	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		overridePendingTransition(R.anim.hold, R.anim.slide_down);		
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
