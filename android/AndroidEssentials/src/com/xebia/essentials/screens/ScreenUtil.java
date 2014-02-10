package com.xebia.essentials.screens;

import android.graphics.Color;

import com.xebia.essentials.model.Card;
import com.xebia.essentials.model.Category;

public class ScreenUtil {
	
	public static int getColotForCard( Card card ) {
		int colorCode;
		
		if( card.getCategory() == Category.collaboration ) {
			
			//colorCode = Color.GREEN;
			colorCode = Color.parseColor("#FC7A25");
    		
    	} else	if( card.getCategory() == Category.craftmanship ) {
    		
    		//colorCode = Color.YELLOW;
			colorCode = Color.parseColor("#107FD5");
    		
    	} else	if( card.getCategory() == Category.technical ) {
    		
    		//colorCode = Color.MAGENTA;
			colorCode = Color.parseColor("#F80068");
    		
    	} else	if( card.getCategory() == Category.testing ) {
    		
    		//colorCode = Color.RED;
			colorCode = Color.parseColor("#6DC726");
    		
    	} else	 {
    		colorCode = Color.WHITE;
    	}
				
		return colorCode;
	}
	
	public static String beautifyTitle( String title ) {
    	StringBuffer sb = new StringBuffer( title.length() );
    	
    	for( int i=0;  i<title.length() ; i++) {
    		if( i==0 ) {
    			sb.append( Character.toUpperCase(title.charAt(i) ));
    		} else if( title.charAt(i) == '-' ) {
    			sb.append( " " );
    		} else {
    			sb.append( title.charAt(i) );
    		}
    	}
    
    	return sb.toString();
    }


}
