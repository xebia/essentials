package com.xebia.essentials.datastore;

import java.util.List;

import com.xebia.essentials.model.Card;
import com.xebia.essentials.model.Category;

public interface CardStoreI {
	
	List<Card> getCardsOnCategory( Category category );
	Card getFirstCard();
	Card getCardOnTitle( String title );
	Card getNextCard( Card card );
	Card getPreviousCard( Card card );
	Card getRandomCard();
	

}
