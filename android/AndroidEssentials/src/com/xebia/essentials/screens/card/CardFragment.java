package com.xebia.essentials.screens.card;

import com.actionbarsherlock.app.SherlockFragment;
import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.datastore.CardStoreI;
import com.xebia.essentials.general.CardApplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFragment extends SherlockFragment implements
		CardView.CardViewListener {
	private static final String LOG_TAG = CardFragment.class.getName();

	public interface CardFragmentListener {
		public void onWebPageSelected(Card card);
	}

	private CardView cardView = null;
	private boolean isVisibleToUser = false;
	private Card card = null;
	private CardFragmentListener activity = null;

	public static Fragment start(Card card) {
		Preconditions.checkArgument(card != null);

		Log.i(LOG_TAG, "Starting fragment for card:" + card.toString());

		CardFragment fragment = new CardFragment();
		Bundle args = new Bundle();
		args.putString("title", card.getTitle());
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		/*
		 * Just for understanding:
		 * Called multiple times in the lifecycle: also when fragment not ready
		 * yet (before onCreate).
		 * 
		 * This callback is also called after resume
		 */
		Log.i(LOG_TAG, "setUserVisibleHint:"
				+ getArguments().getString("title") + "  with visible= "
				+ isVisibleToUser);

		this.isVisibleToUser = isVisibleToUser;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			this.activity = (CardFragmentListener) activity;
		} catch (ClassCastException e) {
			/*
			 * Early warning mechanism: This makes sure that the hosting
			 * activity has implemented the callback interface. If not, it
			 * throws an exception
			 */
			throw new ClassCastException(activity.toString()
					+ " must implement CardFragmentListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		activity = null;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		cardView = (CardView) inflater.inflate(R.layout.card_view, null);

		return cardView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (getArguments() != null) {
			Log.i(LOG_TAG, "onActivityCreated for card:"
					+ getArguments().getString("title"));

			String title = getArguments().getString("title");
			CardStoreI cardStore = ((CardApplication) getActivity()
					.getApplication()).getCardStore();
			card = cardStore.getCardOnTitle(title);
		} else {
			Log.i(LOG_TAG, "onActivityCreated unknown card");
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		if (getArguments() != null) {
			Log.i(LOG_TAG,
					"onResume: for card:" + getArguments().getString("title")
							+ " with status:" + isVisibleToUser);

			/*
			 * Since the pager prepares next and previous pages and also call
			 * onResume on them, The regular moment of painting is not good
			 * enough. A previous of next screen might be displayed. Instead we
			 * should also take the user-visible-state into account. This state
			 * is set via the setUserVisibleHint-callback
			 */
			cardView.setCard(this, card);

		} else {
			Log.i(LOG_TAG, "onResume unknown card");
		}
	}

	public void updateCard(Card card) {
		this.card = card;
		if (this.card != null && this.cardView != null) {
			cardView.setCard(this, this.card);
		} else {
			Log.i(LOG_TAG, "updateCard unknown card");
		}
	}

	@Override
	public void onWebPageSelected(Card card) {
		if (card != null) {
			Log.i(LOG_TAG, "Visit web-page:" + card.getTitle());
			activity.onWebPageSelected(card);
		} else {
			Log.i(LOG_TAG, "onWebPageSelected unknown card");
		}
	}

	

}
