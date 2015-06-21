package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;
import controller.OkButtonRemoveItemAction;

public class RemoveItemFromDatabaseFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private JButton btnOk;

	public RemoveItemFromDatabaseFrame() {
		setTitle("Remove item from Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Item title:");
		lblTitle.setBounds(18, 37, 61, 16);
		contentPane.add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(101, 31, 492, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(473, 85, 117, 29);
		btnOk.addActionListener(new OkButtonRemoveItemAction());
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
	}
	
	public static JTextField getTitleTextField(){
		return textField;
	}

}
