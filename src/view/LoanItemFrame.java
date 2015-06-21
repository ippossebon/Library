package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Book;
import model.CD;
import model.DVD;
import model.VideoGame;
import controller.LoanController;
import controller.OkButtonCloseAction;
import controller.OkLoanButtonAction;

public class LoanItemFrame extends JFrame {

	private JPanel contentPane;
	private LoanController loanController;
	private JTextField titleTextField;
	private JTextField authorTextField;
	private JTextField idTextField;
	private static JTextField memberNameTextField;
	private JTextField typeTextField;
	private JTextField genreTextField;
	private JTextField ageRestrictionTextField;

	public LoanItemFrame(LoanController loanController, String titleToRent) {
		setTitle("Loan item");
		this.loanController = loanController;
		this.loanController.setItemToRent(titleToRent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(18, 10, 100, 16);
		contentPane.add(lblType);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(18, 80, 61, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(18, 40, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(18, 120, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblAgeRestriction = new JLabel("Age restriction:");
		lblAgeRestriction.setBounds(18, 160, 100, 16);
		contentPane.add(lblAgeRestriction);
		
		titleTextField = new JTextField();
		titleTextField.setEditable(false);
		titleTextField.setBounds(120, 40, 400, 28);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setEditable(false);
		authorTextField.setBounds(120, 80, 400, 28);
		contentPane.add(authorTextField);
		authorTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(120, 120, 400, 28);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblMemberName = new JLabel("Member name:");
		lblMemberName.setBounds(18, 223, 100, 16);
		contentPane.add(lblMemberName);
		
		memberNameTextField = new JTextField();
		memberNameTextField.setBounds(120, 223, 400, 28);
		contentPane.add(memberNameTextField);
		memberNameTextField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(445, 263, 75, 29);
		btnOk.addActionListener(new OkButtonCloseAction(this));
		btnOk.addActionListener(new OkLoanButtonAction(this.loanController));
		contentPane.add(btnOk);
		
		typeTextField = new JTextField();
		typeTextField.setEditable(false);
		typeTextField.setBounds(120, 10, 200, 28);
		contentPane.add(typeTextField);
		typeTextField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(259, 160, 61, 16);
		contentPane.add(lblGenre);
		
		genreTextField = new JTextField();
		genreTextField.setEditable(false);
		genreTextField.setBounds(320, 160, 200, 28);
		contentPane.add(genreTextField);
		genreTextField.setColumns(10);
		
		ageRestrictionTextField = new JTextField();
		ageRestrictionTextField.setEditable(false);
		ageRestrictionTextField.setBounds(120, 160, 100, 28);
		contentPane.add(ageRestrictionTextField);
		ageRestrictionTextField.setColumns(10);
		displayItemInformation();
		this.setVisible(true);
	}
	
	private void displayItemInformation(){
		this.titleTextField.setText(this.loanController.getItemToRent().getTitle());
		this.authorTextField.setText(this.loanController.getItemToRent().getAuthor());
		this.idTextField.setText(this.loanController.getItemToRent().getId());
		this.typeTextField.setText(this.loanController.getItemToRent().getType());
		
		if (this.loanController.getItemToRent() instanceof CD){
			CD cd = (CD) this.loanController.getItemToRent();
			this.genreTextField.setText(cd.getGenre());
		}
		else if (this.loanController.getItemToRent() instanceof DVD){
			DVD dvd = (DVD) this.loanController.getItemToRent();
			this.genreTextField.setText(dvd.getGenre());
			this.ageRestrictionTextField.setText("+ " + dvd.getAgeRestriction());
		}
		else if (this.loanController.getItemToRent() instanceof Book){
			Book book = (Book) this.loanController.getItemToRent();
			this.ageRestrictionTextField.setText("+ " + book.getAgeRestriction());
		}
		else if (this.loanController.getItemToRent() instanceof VideoGame){
			VideoGame game = (VideoGame) this.loanController.getItemToRent();
			this.ageRestrictionTextField.setText("+ " + game.getAgeRestriction());
		}
	}
	
	public static JTextField getMemberNameTextField(){
		return memberNameTextField;
	}
}
