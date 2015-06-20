package model;

import java.util.ArrayList;

public class DVD extends Item{

	private int ageRestriction;
	private String genre;
	
	public DVD(String author, String title, String id, int ageRestriction, String genre,  ArrayList<String> categories){
		super("DVD", author, title, id, categories);
		this.setAgeRestriction(ageRestriction);
		this.setGenre(genre);
	}

	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
