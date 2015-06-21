package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoanItemFrame;
import view.NoItemSelectedErrorFrame;
import view.UserFrame;

public class LoanButtonAction implements ActionListener{

	private LoanController loanController;
	
	public LoanButtonAction(LoanController loanController){
		this.loanController = loanController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			String titleToRent = UserFrame.getSearchResultsList().getSelectedValue();
			LoanItemFrame loanItemFrame = new LoanItemFrame(this.loanController, titleToRent);
		}catch(NullPointerException n){
			NoItemSelectedErrorFrame noItemSelectedErrorFrame = new NoItemSelectedErrorFrame();
			noItemSelectedErrorFrame.setVisible(true);
		}
		
	}

}
