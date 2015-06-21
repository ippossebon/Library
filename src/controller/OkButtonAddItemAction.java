package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.Book;
import model.CD;
import model.DVD;
import model.Document;
import model.VideoGame;
import view.AddItemToDatabaseFrame;
import view.ErrorFrame;

public class OkButtonAddItemAction implements ActionListener{

	public OkButtonAddItemAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		checkFields();
	}
	
	public void checkFields(){
		String type = AddItemToDatabaseFrame.getTypeTextField().getText();
		String title = AddItemToDatabaseFrame.getTitleTextField().getText();
		String author = AddItemToDatabaseFrame.getAuthorTextField().getText();
		String categories = AddItemToDatabaseFrame.getCategoriesTextField().getText();
		String id = AddItemToDatabaseFrame.getIDTextField().getText();
		String genre = AddItemToDatabaseFrame.getGenreTextField().getText();
		String ageRestriction = AddItemToDatabaseFrame.getAgeRestrictionTextField().getText();
		int ageRestrictionInt = 0;
		
		if (type.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have a type.");
			errorFrame.setVisible(true);
		}
		else if (title.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have a title.");
			errorFrame.setVisible(true);
		}
		else if (author.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have an author.");
			errorFrame.setVisible(true);
		}
		else if (categories.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have at least one category.");
			errorFrame.setVisible(true);
		}
		else if (id.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have an ID.");
			errorFrame.setVisible(true);
		}
		else if (type.toLowerCase().equals("cd")){
				if (genre.isEmpty()){
					ErrorFrame errorFrame = new ErrorFrame("CD must have a genre.");
					errorFrame.setVisible(true);
				}
		}
		else if (type.toLowerCase().equals("dvd")){
			if (genre.isEmpty()){
				ErrorFrame errorFrame = new ErrorFrame("DVD must have a genre.");
				errorFrame.setVisible(true);
			}
			ageRestrictionInt = Integer.parseInt(ageRestriction);
			if (ageRestriction.isEmpty()){						
				ErrorFrame errorFrame = new ErrorFrame("DVD must have an age restriction.");
				errorFrame.setVisible(true);
			}
					
		}
		else if (type.toLowerCase().equals("book")){
			ageRestrictionInt = Integer.parseInt(ageRestriction);
			if (ageRestriction.isEmpty()){
				ErrorFrame errorFrame = new ErrorFrame("Book must have an age restriction.");
				errorFrame.setVisible(true);
			}
		}
		else if (type.toLowerCase().equals("videogame")){
			ageRestrictionInt = Integer.parseInt(ageRestriction);
			if (ageRestriction.isEmpty()){
				ErrorFrame errorFrame = new ErrorFrame("Videogame must have an age restriction.");
				errorFrame.setVisible(true);
			}
		}
		else if (! Main.getDatabaseController().isIDValid(id)){
			ErrorFrame errorFrame = new ErrorFrame("Item must have an unique ID. This ID already exists.");
			errorFrame.setVisible(true);
		}
		else if (! (type.toLowerCase().equals("book") || type.toLowerCase().equals("cd") || type.toLowerCase().equals("document") || 
				type.toLowerCase().equals("dvd") || type.toLowerCase().equals("videogame"))){
			ErrorFrame errorFrame = new ErrorFrame("Invalid type. Item must be: Book, CD, Document, DVD or Videogame.");
			errorFrame.setVisible(true);
		}
		else {
			createItem(type, title, author, categories, id, genre, ageRestrictionInt);
		}	
	}
	
	private void createItem(String type, String title, String author, String categories, String id, String genre, int ageRestriction){
		String[] categoriesStrings = categories.split(",");
		ArrayList<String> categoriesList = new ArrayList<String>(Arrays.asList(categoriesStrings));
		
		if (type.toLowerCase().equals("book")){
			Book book = new Book(author, title, id, ageRestriction,  categoriesList);
			Main.getDatabaseController().addItemToDatabase(book);
			
			for (String c : categoriesList){
				Main.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		else if (type.toLowerCase().equals("cd")){
			CD cd = new CD(author, title, id, genre,  categoriesList);
			Main.getDatabaseController().addItemToDatabase(cd);
			
			for (String c : categoriesList){
				Main.getDatabaseController().addCategoryToDatabase(c);
			}
			Main.getDatabaseController().addGenreToDatabase(genre);
			
		}
		else if (type.toLowerCase().equals("document")){
			Document document = new Document(author, title, id,  categoriesList);
			Main.getDatabaseController().addItemToDatabase(document);
			
			for (String c : categoriesList){
				Main.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		else if (type.toLowerCase().equals("dvd")){
			DVD dvd = new DVD(author, title, id, ageRestriction, genre,  categoriesList);
			Main.getDatabaseController().addItemToDatabase(dvd);
			
			for (String c : categoriesList){
				Main.getDatabaseController().addCategoryToDatabase(c);
			}
			Main.getDatabaseController().addGenreToDatabase(genre);
		}
		else if (type.toLowerCase().equals("videogame")){
			VideoGame game = new VideoGame(author, title, id, ageRestriction, categoriesList);
			Main.getDatabaseController().addItemToDatabase(game);
			
			for (String c : categoriesList){
				Main.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		Main.getDatabaseController().showDatabase();
	}

}
