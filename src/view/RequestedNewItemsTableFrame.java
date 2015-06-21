package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Main;
import model.RequestedItem;

public class RequestedNewItemsTableFrame extends JFrame{
	private JPanel contentPane;
	private JTable  table;
	
	public RequestedNewItemsTableFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 140, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel dft = new DefaultTableModel();
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> author = new ArrayList<String>();
		
		for (RequestedItem r : Main.getDatabaseController().getNewItemsRequested()){
			type.add(r.getType().toLowerCase());
			title.add(r.getTitle());
			author.add(r.getAuthor());
		}
		
		dft.addColumn("Type", type.toArray());
		dft.addColumn("Title", title.toArray());
		dft.addColumn("Author", author.toArray());
		
		table.setModel(dft);
		contentPane.setVisible(true);
	}
}
