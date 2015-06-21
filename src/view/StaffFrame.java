package view;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.LoanButtonAction;
import controller.LoanController;
import controller.RentedItemsButtonAction;
import database.DatabaseController;

public class StaffFrame extends UserFrame{

	public static final int MAXRESULTSIZE = 100;
	private static DatabaseController databaseController;
	private static JPanel contentPane;

	public StaffFrame(DatabaseController dc) throws IOException 
	{	
		super (dc);
	
		LoanController loanController = new LoanController();
		JButton btnLoan = new JButton("Loan");
		btnLoan.setBounds(634, 121, 117, 29);
		btnLoan.addActionListener(new LoanButtonAction(loanController));
		contentPane.add(btnLoan);
		
		JButton btnRentedItems = new JButton("Rented items");
		btnRentedItems.setBounds(634, 162, 117, 29);
		btnRentedItems.addActionListener(new RentedItemsButtonAction());
		contentPane.add(btnRentedItems);
	}
}
