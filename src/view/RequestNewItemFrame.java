package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OkButtonCloseAction;
import controller.OkRequestNewItemButtonAction;

public class RequestNewItemFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField typeTextField;
	private static JTextField titleTextField;
	private static JTextField authorTextField;

	public RequestNewItemFrame() {
		setTitle("Request new item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(18, 31, 61, 16);
		contentPane.add(lblType);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(18, 82, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(18, 133, 61, 16);
		contentPane.add(lblAuthor);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(91, 31, 295, 28);
		contentPane.add(typeTextField);
		typeTextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(91, 82, 295, 28);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(91, 133, 295, 28);
		contentPane.add(authorTextField);
		authorTextField.setColumns(10);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.setBounds(269, 173, 117, 29);
		btnRequest.addActionListener(new OkRequestNewItemButtonAction());
		btnRequest.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnRequest);
	}
	
	public static JTextField getTypeTextField(){
		return typeTextField;
	}
	
	public static JTextField getTitleTextField(){
		return titleTextField;
	}
	
	public static JTextField getAuthorTextField(){
		return authorTextField;
	}
}
