package com.xebia.essentials.screens.deck;

import java.util.ArrayList;

import com.google.common.base.Preconditions;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Card;
import com.xebia.essentials.model.Category;
import com.xebia.essentials.screens.ScreenUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardListCellView extends LinearLayout {
	public static final Card EMPTY = new Card("unknown", Category.any,
			"Dummy frontline", new ArrayList<String>(),
			"http://www.xebia.com/dummy");
	private TextView categoryView;
	private TextView titleView;;

	public CardListCellView(Context context) {
		super(context);
	}

	public CardListCellView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		categoryView = (TextView) findViewById(R.id.card_list_item_category);
		titleView = (TextView) findViewById(R.id.card_list_item_title);
	}


	public void setCard(Card card) {

		Preconditions.checkArgument(card != null);

		categoryView.setText(card.getCategory().toString());
		titleView.setText( ScreenUtil.beautifyTitle( card.getTitle() ));

		setBackgroundColor(ScreenUtil.getColotForCard(card));

	}

}