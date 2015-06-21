package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.OkButtonCloseAction;

public class ItemNotFoundErrorFrame extends JFrame{
	public ItemNotFoundErrorFrame() {
		setTitle("Error: Item not found");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblErrorItemNot = new JLabel("Error: Item not found in database.");
		lblErrorItemNot.setBounds(22, 29, 240, 16);
		getContentPane().add(lblErrorItemNot);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(237, 47, 80, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		getContentPane().add(btnOk);
	}
}
