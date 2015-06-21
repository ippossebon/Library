package view;

import java.io.IOException;

import javax.swing.JButton;

import controller.AddItemToDatabaseButtonAction;
import controller.RemoveItemFromDatabaseButtonAction;
import database.DatabaseController;

public class SuperStaffFrame extends StaffFrame{
	
	public SuperStaffFrame(DatabaseController databaseController) throws IOException{
		super(databaseController);
		
		JButton btnAddItemToDatabase = new JButton("Add item to Database");
		btnAddItemToDatabase.setBounds(21, 430, 170, 29);
		btnAddItemToDatabase.addActionListener(new AddItemToDatabaseButtonAction());
		add(btnAddItemToDatabase);
		
		JButton btnRemoveItemFromDatabase= new JButton("Remove item from Database");
		btnRemoveItemFromDatabase.setBounds(200, 430, 220, 29);
		btnRemoveItemFromDatabase.addActionListener(new RemoveItemFromDatabaseButtonAction());
		add(btnRemoveItemFromDatabase);
		
	}

}
