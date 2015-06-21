package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RemoveItemFromDatabaseFrame;

public class RemoveItemFromDatabaseButtonAction implements ActionListener{

	public RemoveItemFromDatabaseButtonAction(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RemoveItemFromDatabaseFrame frame = new RemoveItemFromDatabaseFrame();
		frame.setVisible(true);
	}
}
