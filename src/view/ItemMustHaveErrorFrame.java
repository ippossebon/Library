package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class ItemMustHaveErrorFrame extends JFrame {

	private JPanel contentPane;

	public ItemMustHaveErrorFrame(String type, String mustHave) {
		setTitle("Error");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errorLabel = new JLabel();
		errorLabel.setText("Error: " + type + " must have " + mustHave);
		errorLabel.setBounds(21, 33, 396, 62);
		contentPane.add(errorLabel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(462, 143, 117, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
	}

}
