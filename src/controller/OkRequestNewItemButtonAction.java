package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RequestedItem;
import view.InvalidTypeErrorFrame;
import view.ItemAlreadyExistsErrorFrame;
import view.ItemMustHaveErrorFrame;
import view.RequestNewItemFrame;
import view.UserFrame;

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
		if (Main.getDatabaseController().containsItem(title, author, type)){
			ItemAlreadyExistsErrorFrame itemAlreadyExistsErrorFrame = new ItemAlreadyExistsErrorFrame();
			itemAlreadyExistsErrorFrame.setVisible(true);
		}
		else if (! (type.toLowerCase().equals("book") || type.toLowerCase().equals("cd") || type.toLowerCase().equals("document") || 
				type.toLowerCase().equals("dvd") || type.toLowerCase().equals("videogame"))){
			InvalidTypeErrorFrame invalidTypeErrorFrame = new InvalidTypeErrorFrame();
			invalidTypeErrorFrame.setVisible(true);
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
