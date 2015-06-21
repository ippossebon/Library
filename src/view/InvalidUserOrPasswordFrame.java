package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class InvalidUserOrPasswordFrame extends JFrame {

	private JPanel contentPane;

	public InvalidUserOrPasswordFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInvalidUserOr = new JTextPane();
		txtpnInvalidUserOr.setBackground(SystemColor.window);
		txtpnInvalidUserOr.setText("Error: Invalid user or password.");
		txtpnInvalidUserOr.setBounds(43, 21, 297, 16);
		contentPane.add(txtpnInvalidUserOr);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(308, 85, 117, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnOk);
		setVisible(true);
	}
}
