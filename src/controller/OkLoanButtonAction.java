package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ErrorFrame;
import view.LoanItemFrame;
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
