package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Item;
import view.RequestItemFrame;

public class RequestItemButtonAction implements ActionListener{

	private Item item;
	
	public RequestItemButtonAction(Item item){
		this.item = item;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RequestItemController controller = new RequestItemController();
		controller.setItem(this.item);
		RequestItemFrame frame = new RequestItemFrame(controller);
		frame.setVisible(true);
		
	}
	

}
