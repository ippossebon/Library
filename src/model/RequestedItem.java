package model;

public class RequestedItem {
	
	private String type;
	private String title;
	private String author;
	
	public RequestedItem(String type, String title, String author){
		this.setType(type);
		this.setTitle(title);
		this.setAuthor(author);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
