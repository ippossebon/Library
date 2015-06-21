package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RequestedNewItemsTableFrame;

public class ShowRequestedNewItemsButtonAction implements ActionListener{

	public ShowRequestedNewItemsButtonAction(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RequestedNewItemsTableFrame frame = new RequestedNewItemsTableFrame();
		frame.setVisible(true);
	}
}
