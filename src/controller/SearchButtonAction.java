package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StaffFrame;
import view.UserFrame;

public class SearchButtonAction implements ActionListener{
	private SearchController searchController;
	
	public SearchButtonAction(SearchController searchController){
		this.searchController = searchController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (UserFrame.getRadioButtonAuthor().isSelected()){
			this.searchController.setSearchForAuthor(true);
		}
		if (UserFrame.getRadioButtonTitle().isSelected()){
			this.searchController.setSearchForTitle(true);
		}
		if (UserFrame.getRadioButtonIdentifier().isSelected()){
			this.searchController.setSearchForID(true);
		}
		this.searchController.setToSearch(UserFrame.getSearchForItemTextField().getText().toString());
		this.searchController.setAgeRestrictionToSearch(UserFrame.getComboBoxAge().getSelectedItem().toString());
		this.searchController.setCategoryToSearch(UserFrame.getComboBoxCategory().getSelectedItem().toString());
		this.searchController.setGenreToSearch(UserFrame.getComboBoxGenre().getSelectedItem().toString());
		this.searchController.setTypeToSearch(UserFrame.getComboBoxType().getSelectedItem().toString());
		this.searchController.search();
		this.searchController.onSearchFinished();
	}
	
	

}
