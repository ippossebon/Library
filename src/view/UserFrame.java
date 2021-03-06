package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.Item;
import controller.Main;
import controller.SearchButtonAction;
import controller.SearchController;

public class UserFrame extends JFrame {

	private static JPanel contentPane;
	public static final int MAXRESULTSIZE = 100;
	private static JTextField txtSearchForItem;
	private static JList<String> searchResultsList;
	private static JComboBox<String> comboBoxType;
	private static JComboBox<String> comboBoxGenre;
	private static JComboBox<String> comboBoxCategory;
	private static JComboBox<String> comboBoxAge;
	private static JRadioButton rdbtnAuthor;
	private static JRadioButton rdbtnTitle;
	private static JRadioButton rdbtnIdentifier;

	public UserFrame() {
		ButtonGroup group = new ButtonGroup();
		searchResultsList = new JList<String>();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearchForItem = new JTextField();
		txtSearchForItem.setText("Search for item");
		txtSearchForItem.setBounds(21, 6, 601, 28);
		contentPane.add(txtSearchForItem);
		txtSearchForItem.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(165, 177, 1, 16);
		contentPane.add(textArea);
		
		comboBoxType = new JComboBox<String>();
		comboBoxType.setModel(new DefaultComboBoxModel<String>(new String[] {"All", "Book", "CD", "Document", "DVD", "VideoGame"}));
		comboBoxType.setBounds(21, 85, 102, 27);
		contentPane.add(comboBoxType);
		
		comboBoxGenre = new JComboBox<String>();
		comboBoxGenre.setModel(new DefaultComboBoxModel<String>(new String[] {"All"}));
		comboBoxGenre.setBounds(141, 85, 147, 27);
		for (String g : Main.getDatabaseController().getGenresFromDatabase()){
			comboBoxGenre.addItem(g);
		}
		contentPane.add(comboBoxGenre);
		
		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"All"}));
		comboBoxCategory.setBounds(300, 85, 150, 27);
		for (String c : Main.getDatabaseController().getCategoriesFromDatabase()){
			comboBoxCategory.addItem(c);
		}
		comboBoxCategory.setVisible(true);
		contentPane.add(comboBoxCategory);
		
		comboBoxAge = new JComboBox<String>();
		comboBoxAge.setModel(new DefaultComboBoxModel<String>(new String[] {"All", "+ 10 years old", "+ 12 years old", "+ 14 years old", "+ 16 years old", "+ 18 years old"}));
		comboBoxAge.setBounds(462, 85, 160, 27);
		contentPane.add(comboBoxAge);
		
		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(25, 70, 94, 15);
		contentPane.add(typeLabel);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(145, 70, 94, 15);
		contentPane.add(lblGenre);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(305, 70, 94, 15);
		contentPane.add(lblCategory);
		
		JLabel lblAgeRestriction = new JLabel("Age restriction");
		lblAgeRestriction.setBounds(467, 70, 100, 15);
		contentPane.add(lblAgeRestriction);
		
		rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setBounds(21, 35, 102, 23);
		contentPane.add(rdbtnAuthor);
		group.add(rdbtnAuthor);
		
		rdbtnTitle = new JRadioButton("Title");
		rdbtnTitle.setBounds(145, 35, 86, 23);
		contentPane.add(rdbtnTitle);
		group.add(rdbtnTitle);
		
		rdbtnIdentifier = new JRadioButton("Identifier");
		rdbtnIdentifier.setBounds(305, 35, 94, 23);
		contentPane.add(rdbtnIdentifier);
		group.add(rdbtnIdentifier);
		
		SearchController searchController = new SearchController();
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(634, 7, 160, 29);
		btnSearch.addActionListener(new SearchButtonAction(searchController));
		contentPane.add(btnSearch);
	}

	public static void showSearchResult(ArrayList<Item> searchResult){
		DefaultListModel<String> model = new DefaultListModel<String>();
		contentPane.revalidate();
		String[] result = new String[MAXRESULTSIZE];
		
		if (searchResult.isEmpty()){
			model.addElement("No results found.");
			result[0] = "No result found.";
		}
		else{
			int j = 0;
			
			for (Item i : searchResult){
				model.addElement(i.getTitle());
				result[j] = i.getTitle();
				j++;
			}
		}
		searchResultsList.setListData(result);
		searchResultsList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		searchResultsList.setBounds(21, 125, 601, 300);
		searchResultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultsList.setVisible(true);
		
		contentPane.add(searchResultsList);
		contentPane.revalidate();
		searchResultsList.repaint();
	}
	
	public static void resetSearchResult(){
		searchResultsList.removeAll();
		searchResultsList.repaint();
	}
	
	public static JList<String> getSearchResultsList(){
		return searchResultsList;
	}
	
	public static JComboBox<String> getComboBoxType(){
		return comboBoxType;
	}
	
	public static JComboBox<String> getComboBoxGenre(){
		return comboBoxGenre;
	}
	
	public static JComboBox<String> getComboBoxCategory(){
		return comboBoxCategory;
	}
	
	public static JComboBox<String> getComboBoxAge(){
		return comboBoxAge;
	}
	
	public static JRadioButton getRadioButtonAuthor(){
		return rdbtnAuthor;
	}
	
	public static JRadioButton getRadioButtonTitle(){
		return rdbtnTitle;
	}
	
	public static JRadioButton getRadioButtonIdentifier(){
		return rdbtnIdentifier;
	}
	
	public static JTextField getSearchForItemTextField(){
		return txtSearchForItem;
	}
}
