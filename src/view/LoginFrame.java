package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.OkLoginAction;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField nameTextField;
	private  static JPasswordField passwordField;
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Creates the frame
	public LoginFrame() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(100, 26, 220, 28);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JButton okLoginButton = new JButton("OK");
		okLoginButton.setBounds(133, 125, 117, 29);
		okLoginButton.addActionListener(new OkLoginAction());
		contentPane.add(okLoginButton);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(17, 32, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(17, 72, 74, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 66, 220, 28);
		contentPane.add(passwordField);
	}
	
	
	public static JTextField getNameTextField(){
		return nameTextField;
	}
	
	public static JPasswordField getPasswordField(){
		return passwordField;
	}
}
