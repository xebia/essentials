package com.xebia.essentials.datastore;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Preconditions;
import com.xebia.essentials.general.EssentialsExeception;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.model.CardDeck;
import com.xebia.essentials.model.Category;
import com.xebia.essentials.util.MathUtil;

public class FileBasedCardStore implements CardStoreI {
	//private static final String LOG_TAG = FileBasedCardStore.class.getSimpleName();

	private List<Card> cards = null;
	
	public FileBasedCardStore( InputStream is ) {
		Preconditions.checkArgument(is != null);
		
		this.cards = this.readFile( new InputStreamReader(is) );
	}

	public FileBasedCardStore( String jsonFilename ) throws UnsupportedEncodingException {
		Preconditions.checkArgument(jsonFilename != null);
		
    	Reader reader = 
			new InputStreamReader(
						FileBasedCardStore.class.getResourceAsStream(jsonFilename), 
						"UTF-8");

    	this.cards = this.readFile( reader );
	}

	private List<Card> readFile( Reader reader ) throws EssentialsExeception {
		List<Card> cards = null;
		
		Preconditions.checkArgument(reader != null);
		
        try {
        	CardDeck set = CardDeck.fromJson(reader);
        	
        	/*
        	 * Verify if the cards are complete
        	 */
        	List<String> errors = set.validate();
        	if( errors.size() > 0 ) {
            	System.out.println( "Error validating cards" );
            	for( String errMsg : errors ) {
            		System.out.println( "Card validation error:" + errMsg );
            	}
            	throw new EssentialsExeception("Invalid card-deck");
        	} else {
        		cards = set.getCards();
        		
        		/*
        		 * index the cards
        		 */
        		int idx =  0;
        		for( Card card: cards ) {
        			card.setIndex(idx);;
        			idx++;
        		}
        	}

        } catch( Exception exc ) {
        	System.out.println( "Error reading cards " + ":" + exc.getMessage());
        	
        	throw new EssentialsExeception(exc);
        }
        	
		return cards;
	}
	
	private List<Card> getAllCards() {
		
		Preconditions.checkNotNull(cards != null);

		return cards;
	}

	@Override
	public List<Card> getCardsOnCategory(Category category) {
		List<Card> list = new ArrayList<Card>();
		
		Preconditions.checkArgument(category != null);
		Preconditions.checkNotNull(cards != null);

		if( category == Category.any ) {
			list = getAllCards();
		} else {
			for( Card card : this.cards ) {
				if( card.getCategory() == category ) {
					list.add(card);
				}
			}
		}

		return list;
	}

	@Override
	public Card getCardOnTitle(String title) {
		Card found = null;
		
		Preconditions.checkArgument(title != null);
		Preconditions.checkNotNull(cards != null);
		
		for( Card card : this.cards ) {
			if( card.getTitle().equalsIgnoreCase(title)) {
				found = card;
				break;
			}
		}

		return found;
	}

	@Override
	public Card getFirstCard() {
		Card card = null;
		
		Preconditions.checkNotNull(cards != null);
		
		if( cards.size() >= 1 ) {
			card = this.cards.get(0);
		}
		
		return card;
	}
	
	private int getIndexOfCard( Card card ) {
		boolean found = false;
		int idx = 0;
		
		Preconditions.checkArgument(card != null);
		Preconditions.checkNotNull(cards != null);
		
		for( Card c : this.cards ) {
			if( card.getTitle().equalsIgnoreCase(c.getTitle())) {
				found = true;
				break;
			} else {
				idx++;
			}
		}
		
		if( found == false ) {
			return -1;
		}
		return idx;
	}
	
	@Override
	public Card getPreviousCard(Card card) {
		Card found = null;
		
		Preconditions.checkArgument(card != null);
		Preconditions.checkNotNull(cards != null);
		
		int idx = getIndexOfCard( card);
		if( idx == -1 ) {
			System.out.println( "Previous card not found:" + card.toString() );
		} else {
			idx--;
			
			// make it feel as circular buffer
			if( idx == 0 ) {
				idx = this.cards.size()-1;
			}
			found = cards.get(idx);
		}
		
		return found;
	}

	@Override
	public Card getNextCard(Card card) {
		Card found = null;

		Preconditions.checkArgument(card != null);
		Preconditions.checkNotNull(cards != null);

		int idx = getIndexOfCard(card);
		if( idx == -1 ) {
			System.out.println( "Next card not found:" + card.toString() );
		} else {
	
			idx++;
			
			// make it feel as circular buffer
			if( idx == this.cards.size() ) {
				idx = 0;
			}
			found = cards.get(idx);
		}
		
		return found;
	}
	
	
	@Override
	public Card getRandomCard() {
		int randomIndex = MathUtil.randInt(0, cards.size() );
		
		return this.cards.get(randomIndex);
	}

}
