package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class MemberNotOldEnoughErrorFrame extends JFrame {

	private JPanel contentPane;

	public MemberNotOldEnoughErrorFrame() {
		setTitle("Error: Member not old enough");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorMemberNot = new JLabel("Error: Member not old enough to rent this item.");
		lblErrorMemberNot.setBounds(18, 46, 377, 16);
		contentPane.add(lblErrorMemberNot);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new OkButtonCloseAction(this));
		btnOk.setBounds(327, 74, 117, 29);
		contentPane.add(btnOk);
	}

}
