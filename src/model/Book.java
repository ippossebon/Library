package model;

import java.util.ArrayList;

public class Book extends Item{

	private int ageRestriction;
	
	public Book(String author, String title, String id, int ageRestriction,  ArrayList<String> categories){
		super("Book", author, title, id, categories);
		this.setAgeRestriction(ageRestriction);
	}
	
	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
}
