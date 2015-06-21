package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Rent;

public class RentedItemsFrame extends JFrame {

	private JPanel contentPane;
	private JTable  table;

	public RentedItemsFrame() {
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
		ArrayList<String> rentedItems = new ArrayList<String>();
		ArrayList<String> memberNames = new ArrayList<String>();
		
		for (Rent r : StaffFrame.getDatabaseController().getCurrentRentedItems()){
			rentedItems.add(r.getItem().getTitle());
			memberNames.add(r.getMember().getName());
		}
		
		dft.addColumn("Item title", rentedItems.toArray());
		dft.addColumn("Member name", memberNames.toArray());
		
		table.setModel(dft);
		contentPane.setVisible(true);
	}

}
