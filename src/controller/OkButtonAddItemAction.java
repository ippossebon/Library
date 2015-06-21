package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.Book;
import model.CD;
import model.DVD;
import model.Document;
import model.Item;
import model.VideoGame;
import view.AddItemToDatabaseFrame;
import view.InvalidTypeErrorFrame;
import view.ItemMustHaveErrorFrame;
import view.StaffFrame;

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
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "a type");
			mustHaveError.setVisible(true);
		}
		if (title.isEmpty()){
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "a title");
			mustHaveError.setVisible(true);
		}
		if (author.isEmpty()){
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "an author");
			mustHaveError.setVisible(true);
		}
		if (categories.isEmpty()){
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "at least 1 category");
			mustHaveError.setVisible(true);
		}
		if (id.isEmpty()){
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "an ID");
			mustHaveError.setVisible(true);
		}
		else{
			if (type.toLowerCase().equals("cd")){
				if (genre.isEmpty()){
					ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("CD", "a genre");
					mustHaveError.setVisible(true);
				}
			}
			else if (type.toLowerCase().equals("dvd")){
				if (genre.isEmpty()){
					ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("DVD", "a genre");
					mustHaveError.setVisible(true);
				}
				ageRestrictionInt = Integer.parseInt(ageRestriction);
				if (ageRestriction.isEmpty()){						
					ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("DVD", "an age restriction");
					mustHaveError.setVisible(true);
				}
					
			}
			else if (type.toLowerCase().equals("book")){
				ageRestrictionInt = Integer.parseInt(ageRestriction);
				if (ageRestriction.isEmpty()){
					ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Book", "an age restriction");
					mustHaveError.setVisible(true);
				}
			}
			else if (type.toLowerCase().equals("videogame")){
				ageRestrictionInt = Integer.parseInt(ageRestriction);
				if (ageRestriction.isEmpty()){
					ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Videogame", "an age restriction");
					mustHaveError.setVisible(true);
				}
			}
		}
		
		if (! StaffFrame.getDatabaseController().isIDValid(id)){
			ItemMustHaveErrorFrame mustHaveError = new ItemMustHaveErrorFrame("Item", "an unique ID. This ID already exists.");
			mustHaveError.setVisible(true);
		}
		else if (! (type.toLowerCase().equals("book") || type.toLowerCase().equals("cd") || type.toLowerCase().equals("document") || 
				type.toLowerCase().equals("dvd") || type.toLowerCase().equals("videogame"))){
			InvalidTypeErrorFrame invalidTypeErrorFrame = new InvalidTypeErrorFrame();
			invalidTypeErrorFrame.setVisible(true);
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
			StaffFrame.getDatabaseController().addItemToDatabase(book);
			
			for (String c : categoriesList){
				StaffFrame.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		else if (type.toLowerCase().equals("cd")){
			CD cd = new CD(author, title, id, genre,  categoriesList);
			StaffFrame.getDatabaseController().addItemToDatabase(cd);
			
			for (String c : categoriesList){
				StaffFrame.getDatabaseController().addCategoryToDatabase(c);
			}
			StaffFrame.getDatabaseController().addGenreToDatabase(genre);
			
		}
		else if (type.toLowerCase().equals("document")){
			Document document = new Document(author, title, id,  categoriesList);
			StaffFrame.getDatabaseController().addItemToDatabase(document);
			
			for (String c : categoriesList){
				StaffFrame.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		else if (type.toLowerCase().equals("dvd")){
			DVD dvd = new DVD(author, title, id, ageRestriction, genre,  categoriesList);
			StaffFrame.getDatabaseController().addItemToDatabase(dvd);
			
			for (String c : categoriesList){
				StaffFrame.getDatabaseController().addCategoryToDatabase(c);
			}
			StaffFrame.getDatabaseController().addGenreToDatabase(genre);
		}
		else if (type.toLowerCase().equals("videogame")){
			VideoGame game = new VideoGame(author, title, id, ageRestriction, categoriesList);
			StaffFrame.getDatabaseController().addItemToDatabase(game);
			
			for (String c : categoriesList){
				StaffFrame.getDatabaseController().addCategoryToDatabase(c);
			}
		}
		StaffFrame.getDatabaseController().showDatabase();
	}

}
