package model;

import java.util.ArrayList;

public class Document extends Item{

	public Document(String author, String title, String id,  ArrayList<String> categories){
		super("Document", author, title, id, categories);
	}
}
