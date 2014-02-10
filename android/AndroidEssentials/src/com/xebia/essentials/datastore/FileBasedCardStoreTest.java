package com.xebia.essentials.datastore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xebia.essentials.model.Card;
import com.xebia.essentials.model.Category;

public class FileBasedCardStoreTest {
	private  FileBasedCardStore store = null;

	@Before
	public void setUp() throws Exception {
		store = new FileBasedCardStore("./test.json");
	}

	@After
	public void tearDown() throws Exception {
		store = null;
	}

	@Test
	public void testMissingFile() {
		FileBasedCardStore mystore = null;
		
		try {
			mystore = new FileBasedCardStore("./missing.json");
		} catch( Exception exc) {
		}

		assertNull(mystore);
	}
	
	@Test
	public void testInvalidJson() {
		FileBasedCardStore mystore = null;
		
		try {
			 mystore = new FileBasedCardStore("./invalid.json");
		} catch( Exception exc) {
		}
		assertNull(mystore);
	}
	
	@Test
	public void testMissingField() {
		FileBasedCardStore mystore = null;
		
		try {
			 mystore = new FileBasedCardStore("./missing_field.json");
		} catch( Exception exc) {
		}
		assertNull(mystore);
	}
	
	@Test
	public void testGetAllCards() {
		List<Card> cards  = store.getCardsOnCategory(Category.any);
		assertNotNull(cards);
		assertEquals(2, cards.size() );
		{
			Card card = cards.get(0);
			assertNotNull(card);
			assertEquals(Category.craftmanship, card.getCategory() );
			assertEquals("Title1", card.getTitle() );
			assertEquals("FrontLine1", card.getFrontLine() );
			assertEquals(2, card.getBacklines().size() );
			{
				assertEquals("BackLine1", card.getBacklines().get(0) );
				assertEquals("BackLine2", card.getBacklines().get(1) );
			}
			assertEquals("https://www.xebia.com/essentials/1", card.getUrl() );
		}
		{
			Card card = cards.get(1);
			assertNotNull(card);
			assertEquals(Category.collaboration, card.getCategory() );
			assertEquals("Title2", card.getTitle() );
			assertEquals("FrontLine2", card.getFrontLine() );
			assertEquals(2, card.getBacklines().size() );
			{
				assertEquals("BackLine3", card.getBacklines().get(0) );
				assertEquals("BackLine4", card.getBacklines().get(1) );
			}
			assertEquals("https://www.xebia.com/essentials/2", card.getUrl() );
		}
	}

	@Test
	public void testGetCardsOnCategory() {
		List<Card> cards  = store.getCardsOnCategory(Category.craftmanship);
		assertNotNull(cards);
		assertEquals(1, cards.size() );
		{
			Card card = cards.get(0);
			assertNotNull(card);
			assertEquals(Category.craftmanship, card.getCategory() );
		}
	}
	
	@Test
	public void testGetAllCardOnTitle() {
		{
			// not found
			Card card = store.getCardOnTitle("Title3");
			assertNull(card);
		}
		{
			// found
			Card card = store.getCardOnTitle("Title1");
			assertNotNull(card);
			assertEquals("Title1", card.getTitle() );
		}
	}

	@Test
	public void testGetNextCard() {
		{
			Card card = store.getCardOnTitle("Title1");
			assertNotNull(card);
			assertEquals("Title1", card.getTitle() );
			Card next = store.getNextCard(card);
			assertNotNull(next);
			assertEquals("Title2", next.getTitle() );

			Card first = store.getNextCard(next);
			assertNotNull(first);
			assertEquals("Title1", first.getTitle() );
		}
		{
			// current card not present
			Card next = store.getNextCard(
					new Card("Title3", Category.collaboration, "Firstline",
								new ArrayList<String>(), "www.xyz.com"));
			assertNull(next);
		}
	}

	@Test
	public void testGetPreviousCard() {
		{
			Card card = store.getCardOnTitle("Title2");
			assertNotNull(card);
			assertEquals("Title2", card.getTitle() );
			Card next = store.getNextCard(card);
			assertNotNull(next);
			assertEquals("Title1", next.getTitle() );

			Card first = store.getNextCard(next);
			assertNotNull(first);
			assertEquals("Title2", first.getTitle() );
		}
		{
			// current card not present
			Card next = store.getNextCard(
					new Card("Title3", Category.collaboration, "Firstline",
								new ArrayList<String>(), "www.xyz.com"));
			assertNull(next);
		}
	}
	
	@Test
	public void testGetRandomCard() {
		boolean different  = false;
		
		while( different == false ) {
			Card first = store.getRandomCard();
			assertNotNull(first);
		
			Card second = store.getRandomCard();
			assertNotNull(second);
			
			if( ! first.getTitle().equals(second.getTitle() )) {
				different = true;
			}
		}
		
		assertEquals(true, different);
		
		
	}
}
