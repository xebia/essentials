package com.xebia.essentials.screens.deck;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.viewpagerindicator.TitlePageIndicator;
import com.xebia.essentials.R;
import com.xebia.essentials.model.Category;

public class CategoryFragment extends SherlockFragment {
	private static final String LOG_TAG = CategoryFragment.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.category_fragment, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		List<Category> categories = Arrays.asList(Category.values());
		
		CategoryAdapter adapter = new CategoryAdapter(
				getActivity().getSupportFragmentManager(),  categories);

		ViewPager pager = (ViewPager) getActivity().findViewById(R.id.categorypager);
		pager.setAdapter(adapter);
		pager.setCurrentItem(0);

		TitlePageIndicator pageIndicator = (TitlePageIndicator)  getActivity().findViewById(R.id.categoryindicator);
		pageIndicator.setViewPager(pager);
		pageIndicator.setCurrentItem(0);
	}

	@Override 
	public void onResume() {
		super.onResume();


	}
}
