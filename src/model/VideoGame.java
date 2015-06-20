package model;

import java.util.ArrayList;

public class VideoGame extends Item{

	private int ageRestriction;
	
	public VideoGame(String author, String title, String id, int ageRestriction,  ArrayList<String> categories){
		super("VideoGame", author, title, id, categories);
		this.setAgeRestriction(ageRestriction);
	}

	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
}
