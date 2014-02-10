package com.xebia.essentials.model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;

public class Card {
	private int index;
	private String title;
	private Category category;
	private String frontLine;
	private List<String> backlines;
    private String url;
    
	public Card(String title, Category category, String frontLine,
			List<String> backlines, String url) {
		super();
		this.title = title;
		this.category = category;
		this.frontLine = frontLine;
		this.backlines = backlines;
		this.url = url;
	}

	public void setIndex( int index ) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public String getFrontLine() {
		return frontLine;
	}

	public List<String> getBacklines() {
		return backlines;
	}

	public String getUrl() {
		return url;
	}
    
	public List<String> validate() {
		List<String> errors = new ArrayList<String>();
		
		Preconditions.checkNotNull(this);
		
		if( this.title == null ) {
			errors.add("Missing field title");
		}
		if( this.category == null ) {
			errors.add("Missing field category");
		}
		if( this.frontLine == null ) {
			errors.add("Missing field frontLine");
		}
		if( this.backlines == null ) {
			errors.add("Missing field backlines");
		}
		if( this.url == null ) {
			errors.add("Missing field url");
		}
		
		return errors;
	}
	
    public static Card fromJson( String data ) {
    	Gson gson = new Gson();
    	return gson.fromJson(data, Card.class);
    }
    
    public String toJson() {
    	Gson gson = new Gson();
    	return gson.toJson(this); 
    }

	@Override
	public String toString() {
		 return Objects.toStringHelper(this)
		   .add("index", this.index)
	       .add("title", this.title)
	       .add("category", this.category)
	       .add("frontLine", this.frontLine)
	       .add("backLineCount", this.backlines.size())
	       .add("url", this.url)
	       .toString();	
	}


}
