package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoanItemFrame;
import view.MemberNotFoundErrorFrame;
import view.MemberNotOldEnoughErrorFrame;
import view.UnavailableItemErrorFrame;

public class OkLoanButtonAction implements ActionListener{

	private LoanController loanController;
	
	public OkLoanButtonAction(LoanController loanController){
		this.loanController = loanController;
	}

	/* The loan will only succed if the person is a library member and is old enough to rent the item. Moreover, the item must be available
	 * for loan, if not, the user can request it.*/
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if (this.loanController.isMemberOnDatabase(LoanItemFrame.getMemberNameTextField().getText())){
			this.loanController.setMember(LoanItemFrame.getMemberNameTextField().getText());
			
			if (this.loanController.isMemberOldEnough()){
				if (this.loanController.isItemAvailable()){
					this.loanController.loan();
				}
				else{
					UnavailableItemErrorFrame unavailableItemErrorFrame = new UnavailableItemErrorFrame(this.loanController.getItemToRent());
					unavailableItemErrorFrame.setVisible(true);
				}
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
