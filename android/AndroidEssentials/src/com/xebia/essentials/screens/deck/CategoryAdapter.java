package com.xebia.essentials.screens.deck;


import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xebia.essentials.model.Category;
import com.xebia.essentials.screens.ScreenUtil;
import com.xebia.essentials.screens.deck.CardListFragment;

public class CategoryAdapter extends FragmentPagerAdapter {
	private List<Category> categories = null;
	
	public CategoryAdapter(FragmentManager fm, List<Category> categories ) {
		super(fm);
		this.categories = categories;
	}

	@Override
	public Fragment getItem(int position) {
		return CardListFragment.start(categories.get(position));
	}

	@Override
	public int getCount() {
		return categories.size();

	}

	@Override
	public CharSequence getPageTitle(int position) {
		return ScreenUtil.beautifyTitle(categories.get(position).toString() );
	}

}