package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ItemNotFoundErrorFrame;
import view.RemoveItemFromDatabaseFrame;

public class OkButtonRemoveItemAction implements ActionListener{

	public OkButtonRemoveItemAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			String titleToRemove = RemoveItemFromDatabaseFrame.getTitleTextField().getText();
			Main.getDatabaseController().removeItemFromDatabase(titleToRemove);
			Main.getDatabaseController().showDatabase();
		}catch (NullPointerException n){
			ItemNotFoundErrorFrame itemNotFoundErrorFrame = new ItemNotFoundErrorFrame();
			itemNotFoundErrorFrame.setVisible(true);
		}
		
	}

}
