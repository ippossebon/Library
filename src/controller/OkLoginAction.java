package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.LoginFrame;

public class OkLoginAction implements ActionListener{
	
	public OkLoginAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LoginController loginController = new LoginController(LoginFrame.getNameTextField().getText().toString(), 
																LoginFrame.getPasswordField().getText().toString());
	}

}
