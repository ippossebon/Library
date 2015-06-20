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

	@Override
	public void actionPerformed(ActionEvent e) {
			
		if (this.loanController.isMemberOnDatabase(LoanItemFrame.getMemberNameTextField().getText())){
			this.loanController.setMember(LoanItemFrame.getMemberNameTextField().getText());
			
			if (this.loanController.isMemberOldEnough()){
				if (this.loanController.isItemAvailable()){
					this.loanController.loan();
				}
				else{
					// Imprime erro: item nao esta disponivel.. pergunta se quer reservar
					UnavailableItemErrorFrame unavailableItemErrorFrame = new UnavailableItemErrorFrame(this.loanController.getItemToRent());
					unavailableItemErrorFrame.setVisible(true);
				}
			}
			else{
				// Imprime erro: membro nao tem idade suficiente
				MemberNotOldEnoughErrorFrame memberNotOldEnoughErrorFrame = new MemberNotOldEnoughErrorFrame();
				memberNotOldEnoughErrorFrame.setVisible(true);
			}
		}
		else{
			//imprime mensagem de erro: membro nao encontrado.
			MemberNotFoundErrorFrame memberNotFoundErrorFrame = new MemberNotFoundErrorFrame();
			memberNotFoundErrorFrame.setVisible(true);
		}	
	}
	
	
}
