package com.xebia.essentials.screens.deck;

import java.util.List;

import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CardListAdapter extends BaseAdapter {

	private List<Card> cards;
	private final LayoutInflater inflater;

	public CardListAdapter(Context context, List<Card> cards) {
		this.cards = cards;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CardListCellView view;
		if (convertView == null) {
			view = (CardListCellView) inflater.inflate(R.layout.card_cell_view, null);
		} else {
			view = (CardListCellView) convertView;
		}
		Card item = getItem(position);
		view.setCard(item);
		return view;
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public Card getItem(int position) {
		return cards.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

}
