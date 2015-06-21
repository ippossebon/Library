package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class NoItemSelectedErrorFrame extends JFrame {

	private JPanel contentPane;

	public NoItemSelectedErrorFrame() {
		setTitle("Error: No item was selected");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errorLabel = new JLabel("Error: No item was selected.");
		errorLabel.setBounds(21, 10, 200, 50);
		contentPane.add(errorLabel);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an item for this operation.");
		lblPleaseSelectAn.setBounds(21, 40, 343, 50);
		contentPane.add(lblPleaseSelectAn);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(313, 73, 117, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
	}
}
