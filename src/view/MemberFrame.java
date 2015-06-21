package view;

import javax.swing.JButton;

import controller.RequestNewItemButtonAction;

public class MemberFrame extends UserFrame {

	public MemberFrame(){
		super();
		
		JButton btnLoan = new JButton("Request new item");
		btnLoan.setBounds(634, 121, 140, 29);
		btnLoan.addActionListener(new RequestNewItemButtonAction());
		add(btnLoan);
	}
}
