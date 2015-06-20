package model;

import java.util.ArrayList;

public class Item {
	
	private String type;
	private String author;
	private String title;
	private ArrayList<String> categories;
	private String id;
	private boolean available;
	
	public Item(String type, String author, String title, String id, ArrayList<String> categories){
		this.setType(type);
		this.setAuthor(author);
		this.setTitle(title);
		this.setCategories(new ArrayList<String>());
		this.setId(id);
		this.setAvailable(true);
		
		for (String c : categories){
			addCategory(c);
		}
	}
	
	public Item(){
		this.setType(null);
		this.setAuthor(null);
		this.setTitle(null);
		this.setCategories(new ArrayList<String>());
		this.setId(null);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
	
	public void addCategory(String category){
		this.categories.add(category);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
