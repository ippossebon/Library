package view;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;

public class ErrorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField errorTextField;
	private JButton btnOk;
	private String textError;

	public ErrorFrame(String textError) {
		this.textError = textError;
		setTitle("Error");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errorLabel = new JLabel("Error:");
		errorLabel.setBounds(20, 29, 61, 16);
		contentPane.add(errorLabel);
		
		errorTextField = new JTextField();
		errorTextField.setText(this.textError);
		errorTextField.setBackground(SystemColor.window);
		errorTextField.setEditable(false);
		errorTextField.setBounds(20, 51, 507, 28);
		contentPane.add(errorTextField);
		errorTextField.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new OkButtonCloseAction(this));
		btnOk.setBounds(410, 81, 117, 29);
		contentPane.add(btnOk);
	}
}
