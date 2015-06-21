package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RemoveItemFromDatabaseFrame;
import view.StaffFrame;
import view.UserFrame;

public class OkButtonRemoveItemAction implements ActionListener{

	public OkButtonRemoveItemAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			String titleToRemove = RemoveItemFromDatabaseFrame.getTitleTextField().getText();
			UserFrame.getDatabaseController().removeItemFromDatabase(titleToRemove);
			UserFrame.getDatabaseController().showDatabase();
		}catch (NullPointerException n){
			System.out.println("Item not found in database.");
		}
		
	}

}
