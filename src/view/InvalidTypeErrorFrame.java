package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class InvalidTypeErrorFrame extends JFrame {

	private JPanel contentPane;

	public InvalidTypeErrorFrame() {
		setTitle("Error: Invalid item type");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorInvalidItem = new JLabel("Error: Invalid item type.");
		lblErrorInvalidItem.setBounds(26, 26, 321, 16);
		contentPane.add(lblErrorInvalidItem);
		
		JLabel lblAvailableTypesBook = new JLabel("Available types: Book, CD, Document, DVD or Videogame.");
		lblAvailableTypesBook.setBounds(26, 54, 400, 16);
		contentPane.add(lblAvailableTypesBook);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(307, 96, 117, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
	}

}
