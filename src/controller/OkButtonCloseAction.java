package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OkButtonCloseAction implements ActionListener{
	private JFrame frame;
		
	public OkButtonCloseAction(JFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.frame.dispose();
	}
		
}