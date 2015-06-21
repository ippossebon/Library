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
		Main.getLoginController().setUserName(LoginFrame.getNameTextField().getText().toString());
		Main.getLoginController().setUserPassword(LoginFrame.getPasswordField().getText().toString());
		Main.getLoginController().setInterfaceOption();
		Main.getLoginController().createInterface();
	}

}
