package controller;

import java.io.IOException;

import view.InvalidUserOrPasswordFrame;
import view.MemberFrame;
import view.StaffFrame;
import view.SuperStaffFrame;
import database.DatabaseController;

public class LoginController{
	private String userName;
	private String userPassword;
	private int interfaceOption;
	
	public LoginController(){
	}
	
	public void setInterfaceOption(){
		this.interfaceOption = Main.getDatabaseController().checkLogin(this.userName, this.userPassword);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public void createInterface(){
		// Checks which interface must be create according to the user.
		switch(this.interfaceOption){
		case 0:
			try {
					StaffFrame staffFrame = new StaffFrame();
					staffFrame.setVisible(true);
				}catch (NullPointerException e){ 	
					InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
					invalid_user_password_frame.setVisible(true);
					e.printStackTrace();
					
				} catch (IOException e1){
					InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
					invalid_user_password_frame.setVisible(true);
					e1.printStackTrace();
				}	
				break;	
				case 1:
					try {
						SuperStaffFrame superStaffFrame = new SuperStaffFrame();
						superStaffFrame.setVisible(true);
					} catch (NullPointerException e){ 
						InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
						invalid_user_password_frame.setVisible(true);
						e.printStackTrace();
						
					} catch (IOException e1){
						InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
						invalid_user_password_frame.setVisible(true);
						e1.printStackTrace();
					}
					break;
				case 2:
					try{
						MemberFrame memberFrame = new MemberFrame();
						memberFrame.setVisible(true);
					}catch(NullPointerException e){
						InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
						invalid_user_password_frame.setVisible(true);
						e.printStackTrace();
					}
					break;
				default:
					InvalidUserOrPasswordFrame invalid_user_password_frame = new InvalidUserOrPasswordFrame();
					invalid_user_password_frame.setVisible(true);
					break;
		}
	}

}
