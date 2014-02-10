package com.xebia.essentials.model;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
import com.google.gson.Gson;

public class CardDeck {
	private List<Card> cards;

	public CardDeck( List<Card> cards ) {
		this.cards = cards;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public List<String> validate() {
		List<String> errors = new ArrayList<String>();
		
		for( Card card : this.cards ) {
			errors.addAll( card.validate() );
		}
		
		return errors;
	}
	
	public static CardDeck fromJson(String data) {
		Gson gson = new Gson();
		return gson.fromJson(data, CardDeck.class);
	}

	public static CardDeck fromJson(Reader reader) {
		Gson gson = new Gson();
		return gson.fromJson(reader, CardDeck.class);
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	@Override
	public String toString() {
		 return Objects.toStringHelper(this)
	       .add("cards", cards)
	       .toString();	
	}
}
