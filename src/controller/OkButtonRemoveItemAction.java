package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RemoveItemFromDatabaseFrame;
import view.StaffFrame;

public class OkButtonRemoveItemAction implements ActionListener{

	public OkButtonRemoveItemAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			String titleToRemove = RemoveItemFromDatabaseFrame.getTitleTextField().getText();
			StaffFrame.getDatabaseController().removeItemFromDatabase(titleToRemove);
			StaffFrame.getDatabaseController().showDatabase();
		}catch (NullPointerException n){
			System.out.println("Item not found in database.");
		}
		
	}

}
