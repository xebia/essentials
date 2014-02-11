package com.xebia.essentials.screens.deck;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.model.Category;
import com.xebia.essentials.general.CardApplication;

public class CardListFragment extends SherlockListFragment {
	private static final String LOG_TAG = CardListFragment.class.getName();

	public interface CardListFragmentListener {
		public void onCardSelected(Card card);
	}

	private List<Card> cards = null;
	private CardListFragmentListener activity = null;

	public static CardListFragment start(Category category) {
		
		Preconditions.checkArgument(category != null);
		
		CardListFragment fragment = new CardListFragment();
		Bundle args = new Bundle();
		args.putString("category", category.toString());
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		/* 
		 * This makes sure that the container activity has implemented
		 * the callback interface. If not, throw an exception
		 */
		try {
			this.activity = (CardListFragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement CardListFragmentListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		activity = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.card_list_fragment, null);
	}

	@Override
	public void onCreate(Bundle onCreate) {
		super.onCreate(onCreate);

		Log.i(LOG_TAG, "onCreate");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.i(LOG_TAG,
				"onActivityCreated for category:" + getArguments().getString("category"));

		CardStoreI cardStore = ((CardApplication) getActivity().getApplication())
				.getCardStore();

		String category = getArguments().getString("category");
		cards = cardStore.getCardsOnCategory(Category.valueOf(category));
		setListAdapter(new CardListAdapter(getActivity(), cards));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Card card = cards.get(position);

		/*
		 * call hosting activity (do not care which 
		 * 	one as long as it implements CardListFragmentListener
		 */
		activity.onCardSelected(card);
	}

}
