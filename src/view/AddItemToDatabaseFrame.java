package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OkButtonAddItemAction;
import controller.OkButtonCloseAction;

public class AddItemToDatabaseFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField typeTextField;
	private static JTextField titleTextField;
	private static JTextField authorTextField;
	private static JTextField categoriesTextField;
	private static JTextField idTextField;
	private static JTextField genreTextField;
	private static JTextField ageRestrictionTextField;

	public AddItemToDatabaseFrame() {
		setTitle("Add item to Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(6, 58, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(6, 102, 61, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(6, 14, 61, 16);
		contentPane.add(lblType);
		
		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setBounds(6, 146, 80, 16);
		contentPane.add(lblCategories);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(6, 190, 61, 16);
		contentPane.add(lblId);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(124, 14, 282, 28);
		contentPane.add(typeTextField);
		typeTextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(124, 58, 282, 28);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(124, 102, 282, 28);
		contentPane.add(authorTextField);
		authorTextField.setColumns(10);
		
		categoriesTextField = new JTextField();
		categoriesTextField.setBounds(124, 146, 282, 28);
		contentPane.add(categoriesTextField);
		categoriesTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setBounds(124, 190, 282, 28);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		genreTextField = new JTextField();
		genreTextField.setBounds(124, 234, 282, 28);
		contentPane.add(genreTextField);
		genreTextField.setColumns(10);
		
		ageRestrictionTextField = new JTextField();
		ageRestrictionTextField.setBounds(124, 278, 282, 28);
		contentPane.add(ageRestrictionTextField);
		ageRestrictionTextField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(6, 234, 61, 16);
		contentPane.add(lblGenre);
		
		JLabel lblAgeRestriction = new JLabel("Age restriction:");
		lblAgeRestriction.setBounds(6, 278, 106, 16);
		contentPane.add(lblAgeRestriction);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(290, 325, 117, 29);
		btnAdd.addActionListener(new OkButtonAddItemAction());
		btnAdd.addActionListener(new OkButtonCloseAction(this));
		contentPane.add(btnAdd);
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
	
	public static JTextField getCategoriesTextField(){
		return categoriesTextField;
	}
	
	public static JTextField getIDTextField(){
		return idTextField;
	}
	
	public static JTextField getGenreTextField(){
		return genreTextField;
	}
	
	public static JTextField getAgeRestrictionTextField(){
		return ageRestrictionTextField;
	}
	
}
