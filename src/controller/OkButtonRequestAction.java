package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MemberNotFoundErrorFrame;
import view.MemberNotOldEnoughErrorFrame;
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
				MemberNotOldEnoughErrorFrame memberNotOldEnoughErrorFrame = new MemberNotOldEnoughErrorFrame();
				memberNotOldEnoughErrorFrame.setVisible(true);
				
			}
		}
		else{
			MemberNotFoundErrorFrame memberNotFoundErrorFrame = new MemberNotFoundErrorFrame();
			memberNotFoundErrorFrame.setVisible(true);
		}
		
	}
	
	

}
