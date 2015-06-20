package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class InvalidUserOrPasswordFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvalidUserOrPasswordFrame frame = new InvalidUserOrPasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvalidUserOrPasswordFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnOk.addActionListener(new OkAction(this));
		contentPane.add(btnOk);
	}
	
	private class OkAction implements ActionListener{
		private InvalidUserOrPasswordFrame frame;
		
		public OkAction(InvalidUserOrPasswordFrame frame){
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			this.frame.dispose();
		}
		
	}
}
