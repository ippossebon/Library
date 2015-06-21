package view;

import java.io.IOException;

import javax.swing.JButton;

import controller.LoanButtonAction;
import controller.LoanController;
import controller.RentedItemsButtonAction;
import controller.ShowRequestedNewItemsButtonAction;

public class StaffFrame extends UserFrame{

	public StaffFrame() throws IOException 
	{	
		super ();
	
		LoanController loanController = new LoanController();
		JButton btnLoan = new JButton("Loan");
		btnLoan.setBounds(634, 121, 160, 29);
		btnLoan.addActionListener(new LoanButtonAction(loanController));
		add(btnLoan);
		
		JButton btnRentedItems = new JButton("Rented items");
		btnRentedItems.setBounds(634, 162, 160, 29);
		btnRentedItems.addActionListener(new RentedItemsButtonAction());
		add(btnRentedItems);
		
		JButton btnRequestedNewItem = new JButton("Requested new items");
		btnRequestedNewItem.setBounds(634, 203, 160, 29);
		btnRequestedNewItem.addActionListener(new ShowRequestedNewItemsButtonAction());
		add(btnRequestedNewItem);
	}
}
