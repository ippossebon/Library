package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RequestNewItemFrame;

public class RequestNewItemButtonAction implements ActionListener{

	public RequestNewItemButtonAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RequestNewItemFrame frame = new RequestNewItemFrame();
		frame.setVisible(true);
		
	}

}
