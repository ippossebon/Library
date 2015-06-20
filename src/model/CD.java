package model;

import java.util.ArrayList;

public class CD extends Item{
	
	private String genre;
	
	public CD(String author, String title, String id, String genre,  ArrayList<String> categories){
		super("CD", author, title, id, categories);
		this.setGenre(genre);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
