package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class MemberNotFoundErrorFrame extends JFrame {

	private JPanel contentPane;

	public MemberNotFoundErrorFrame() {
		setTitle("Error: Member not found");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberNotFound = new JLabel("Error: Member not found on database. Please enter a valid member name.");
		lblMemberNotFound.setBounds(6, 33, 528, 16);
		contentPane.add(lblMemberNotFound);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new OkButtonCloseAction(this));
		btnOk.setBounds(399, 65, 117, 29);
		contentPane.add(btnOk);
	}

}
