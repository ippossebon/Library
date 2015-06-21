package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddItemToDatabaseFrame;

public class AddItemToDatabaseButtonAction implements ActionListener{

	public AddItemToDatabaseButtonAction(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddItemToDatabaseFrame addItemToDatabaseFrame = new AddItemToDatabaseFrame();
		addItemToDatabaseFrame.setVisible(true);
	}
}
