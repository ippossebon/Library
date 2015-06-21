package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RequestedItem;
import view.ErrorFrame;
import view.RequestNewItemFrame;

public class OkRequestNewItemButtonAction implements ActionListener{

	public OkRequestNewItemButtonAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		checkFields();
	}

	private void checkFields(){
		String type = RequestNewItemFrame.getTypeTextField().getText();
		String title = RequestNewItemFrame.getTitleTextField().getText();
		String author = RequestNewItemFrame.getAuthorTextField().getText();
		
		if (type.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have a type.");
			errorFrame.setVisible(true);
		}
		if (title.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have a title.");
			errorFrame.setVisible(true);
		}
		if (author.isEmpty()){
			ErrorFrame errorFrame = new ErrorFrame("Item must have an author.");
			errorFrame.setVisible(true);
		}
		if (Main.getDatabaseController().containsItem(title, author, type)){
			ErrorFrame errorFrame = new ErrorFrame("This item already exists in database.");
			errorFrame.setVisible(true);
		}
		else if (! (type.toLowerCase().equals("book") || type.toLowerCase().equals("cd") || type.toLowerCase().equals("document") || 
				type.toLowerCase().equals("dvd") || type.toLowerCase().equals("videogame"))){
			ErrorFrame errorFrame = new ErrorFrame("Invalid type. Item must be: Book, CD, Document, DVD or Videogame.");
			errorFrame.setVisible(true);
		}
		else {
			createNewItemRequest(type, title, author);
		}	
	}
	
	private void createNewItemRequest(String type, String title, String author){
		RequestedItem requestedItem = new RequestedItem(type, title, author);
		Main.getDatabaseController().addNewRequestedItem(requestedItem);
		Main.getDatabaseController().printRequestedItems();
	}
}
