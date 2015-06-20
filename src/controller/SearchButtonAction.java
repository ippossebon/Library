package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StaffFrame;

public class SearchButtonAction implements ActionListener{
	private SearchController searchController;
	
	public SearchButtonAction(SearchController searchController){
		this.searchController = searchController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (StaffFrame.getRadioButtonAuthor().isSelected()){
			this.searchController.setSearchForAuthor(true);
		}
		if (StaffFrame.getRadioButtonTitle().isSelected()){
			this.searchController.setSearchForTitle(true);
		}
		if (StaffFrame.getRadioButtonIdentifier().isSelected()){
			this.searchController.setSearchForID(true);
		}
		this.searchController.setToSearch(StaffFrame.getSearchForItemTextField().getText().toString());
		this.searchController.setAgeRestrictionToSearch(StaffFrame.getComboBoxAge().getSelectedItem().toString());
		this.searchController.setCategoryToSearch(StaffFrame.getComboBoxCategory().getSelectedItem().toString());
		this.searchController.setGenreToSearch(StaffFrame.getComboBoxGenre().getSelectedItem().toString());
		this.searchController.setTypeToSearch(StaffFrame.getComboBoxType().getSelectedItem().toString());
		this.searchController.search();
		this.searchController.onSearchFinished();
	}
	
	

}
