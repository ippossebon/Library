package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Item;
import controller.OkButtonCloseAction;
import controller.RequestItemButtonAction;

public class UnavailableItemErrorFrame extends JFrame {

	private JPanel contentPane;

	public UnavailableItemErrorFrame(Item item) {
		setTitle("Error: Item not available");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorItemNot = new JLabel("Error: Item not available.");
		lblErrorItemNot.setBounds(16, 33, 198, 16);
		contentPane.add(lblErrorItemNot);
		
		JLabel lblDoYouWant = new JLabel("Do you want to request this item?");
		lblDoYouWant.setBounds(16, 68, 310, 16);
		contentPane.add(lblDoYouWant);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(16, 119, 75, 29);
		btnYes.addActionListener(new OkButtonCloseAction(this));
		System.out.println(item.getTitle());
		btnYes.addActionListener(new RequestItemButtonAction(item));
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(103, 119, 75, 29);
		btnNo.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnNo);
	}

}
