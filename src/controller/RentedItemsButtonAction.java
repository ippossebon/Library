package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RentedItemsFrame;

public class RentedItemsButtonAction implements ActionListener{

	public RentedItemsButtonAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RentedItemsFrame rentedItemsFrame = new RentedItemsFrame();
		rentedItemsFrame.setVisible(true);
	}

}
