package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ErrorFrame;
import view.RequestItemFrame;

public class OkButtonRequestAction implements ActionListener{
	
	private RequestItemController requestCotroller;
	
	public OkButtonRequestAction(RequestItemController controller){
		this.requestCotroller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.requestCotroller.setMember(RequestItemFrame.getMemberNameTextField().getText());
		if (this.requestCotroller.isMemberOnDatabase()){
			
			if (this.requestCotroller.isMemberOldEnough()){
				this.requestCotroller.request();
			}
			else{
				ErrorFrame errorFrame = new ErrorFrame("Member is not old enough to rent this item.");
				errorFrame.setVisible(true);
				
			}
		}
		else{
			ErrorFrame errorFrame = new ErrorFrame("Member not found.");
			errorFrame.setVisible(true);
		}
		
	}
	
	

}
