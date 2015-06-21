package controller;

import view.LoginFrame;
import database.DatabaseController;

public class Main {
	private static DatabaseController databaseController;
	private static LoginController loginController;

	public static void main(String[] args) {
		databaseController = new DatabaseController();
		loginController = new LoginController();
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}

	public static DatabaseController getDatabaseController() {
		return databaseController;
	}

	public static void setDatabaseController(DatabaseController databaseController) {
		Main.databaseController = databaseController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static void setLoginController(LoginController loginController) {
		Main.loginController = loginController;
	}
	

}
