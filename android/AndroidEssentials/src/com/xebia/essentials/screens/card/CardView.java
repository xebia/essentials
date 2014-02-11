package com.xebia.essentials.screens.card;

import java.util.List;

import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.screens.ScreenUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * Dumb view, get its data and passes events back to its presenter
 */
public class CardView extends LinearLayout {
	private static final String LOG_TAG = CardView.class.getName();
	
	public interface CardViewListener {
        public void onWebPageSelected(Card card);
    }
	
    private ViewGroup categoryHeader = null;
    private TextView titleView  = null;
    private TextView categoryView  = null;
    private TextView frontlineView  = null;
    private TextView backlineView  = null;
    
    private CardViewListener presenter;
    
    private Card card = null;
        
    public CardView(Context context) {
        super(context);
    }
 
    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        
        categoryHeader = (ViewGroup) findViewById(R.id.cardview_header_id);
        categoryView = (TextView) findViewById(R.id.cardview_category);
        titleView = (TextView) findViewById(R.id.cardview_title);
        frontlineView = (TextView) findViewById(R.id.cardview_frontline);
        backlineView = (TextView) findViewById(R.id.cardview_backlines);
        
        final Button button = (Button) findViewById(R.id.cardview_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	detailsButtonClicked( );
            }
        });
    }
    
    private String concatenateBacklines( List<String> backlines ) {
    	StringBuffer sb = new StringBuffer();
    	
    	for( String line : backlines ) {
    		sb.append( " * " + line + "\n" );
    	}
    	
    	return sb.toString();
    }
    
	/*
	 * Populate screen from data
	 */
    public void setCard( CardViewListener presenter, Card card ) {
    	
    	Preconditions.checkArgument(presenter != null);
    	Preconditions.checkArgument(card != null);
    	
    	this.presenter = presenter;
    	this.card = card;
    	
    	Log.i(LOG_TAG, "setCard:"+ card.toString() );
    	
    	categoryHeader.setBackgroundColor( ScreenUtil.getColotForCard(card) );
    	categoryView.setText( card.getCategory().toString() );
    	titleView.setText( ScreenUtil.beautifyTitle( card.getTitle() ) );
    	frontlineView.setText( card.getFrontLine() );
    	backlineView.setText( concatenateBacklines( card.getBacklines() ) );
    }
    
    private void detailsButtonClicked() {
    	
    	if( presenter != null && card != null ) {
    		/*
    		 * Delegate to its "presenter"
    		 */
    		presenter.onWebPageSelected(this.card);
    	}
    }
    

}