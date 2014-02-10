package com.xebia.essentials.screens.card;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.xebia.essentials.model.Card;

public class CardAdapter extends FragmentPagerAdapter  {
	private static final String LOG_TAG = CardAdapter.class.getName();

	private List<Card> cards = null;

	public CardAdapter(FragmentManager fm, List<Card> cards ) {
		super(fm);

		this.cards  = cards;
	}

	@Override
	public Fragment getItem(int position) {
		return CardFragment.start(cards.get(position));
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		 Log.i(LOG_TAG, "getPageTitle " + position);
		return cards.get(position).getTitle();
	}          
}