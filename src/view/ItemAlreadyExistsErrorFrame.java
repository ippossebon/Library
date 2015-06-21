package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class ItemAlreadyExistsErrorFrame extends JFrame {

	private JPanel contentPane;

	public ItemAlreadyExistsErrorFrame() {
		setTitle("Error: Existing item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errorLabel = new JLabel("This item already exists in the database.");
		errorLabel.setBounds(27, 31, 301, 16);
		contentPane.add(errorLabel);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter a new item.");
		lblPleaseEnterA.setBounds(27, 59, 266, 16);
		contentPane.add(lblPleaseEnterA);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(211, 97, 117, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
	}

}
