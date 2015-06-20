package controller;

import java.util.ArrayList;

import model.Book;
import model.CD;
import model.DVD;
import model.Item;
import model.VideoGame;
import view.StaffFrame;
import database.DatabaseController;

public class SearchController {
	private DatabaseController databaseController;
	private String toSearch;
	private ArrayList<Item> foundResults;
	private boolean searchForID;
	private boolean searchForTitle;
	private boolean searchForAuthor;
	private String typeToSearch;
	private String genreToSearch;
	private String categoryToSearch;
	private int ageRestrictionToSearch;
	
	public SearchController(DatabaseController databaseController){
		this.databaseController = databaseController;
		this.foundResults = new ArrayList<Item>();
	}

	public String getToSearch() {
		return toSearch;
	}

	public void setToSearch(String toSearch) {
		
		try{
			if (this.toSearch.equals("Search for item")){
				this.toSearch = "All";
			}
			else{
				this.toSearch = toSearch;
			}
		}
		catch (NullPointerException e){
			this.toSearch = "All";
		}
	}
	
	public void search(){
		if (this.searchForID){
			this.foundResults = searchForID();
		}
		else if (this.searchForTitle){
			this.foundResults = searchForTitle();
		}
		else if (this.searchForAuthor){
			this.foundResults = searchForAuthor();
		}
		else if (this.toSearch.equals("All")){
			this.foundResults = returnAllDatabase();
		}
		this.foundResults = mixedSearch();
		resetFilters();
	}
	
	private ArrayList<Item> searchForType(){
		for (Item i : this.databaseController.getItems()){
			if (i.getType().equals(typeToSearch)){
				this.foundResults.add(i);
			}
		}	
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForGenre(){	
		for (Item i: this.databaseController.getItems()){
			// Only CDs and DVDs have a genre.
			if (i instanceof CD){
				CD x = (CD) i;
				if (x.getGenre().equals(this.genreToSearch)){
					this.foundResults.add(x);
				}
			}
			if (i instanceof DVD){
				DVD y = (DVD) i;
				if (y.getGenre().equals(this.genreToSearch)){
					this.foundResults.add(y);
				}
			}		
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForID(){
		if (toSearch == null){
			for (Item i: this.databaseController.getItems()){
				this.foundResults.add(i);
			}
		}
		else{
			for (Item i: this.databaseController.getItems()){
				if (i.getId() == toSearch){
					this.foundResults.add(i);
				}
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForTitle(){
		if (toSearch == null){
			for (Item i: this.databaseController.getItems()){
				this.foundResults.add(i);
			}
		}
		else
		{
			for (Item i: this.databaseController.getItems()){
				if (i.getTitle().equals(toSearch)){
					this.foundResults.add(i);
				}
			}	
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForAuthor(){
		
		if (toSearch == null){
			for (Item i: this.databaseController.getItems()){
				this.foundResults.add(i);
			}
		}
		else
		{
			for (Item i: this.databaseController.getItems()){
				if (i.getAuthor().equals(toSearch)){
					this.foundResults.add(i);
				}
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForCategory(){
		for (Item i: this.databaseController.getItems()){
			for (String c : i.getCategories()){
				if (c.equals(categoryToSearch)){
					this.foundResults.add(i);
				}
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> searchForAgeRestriction(){
		for (Item i : this.databaseController.getItems()){
			// Only books, dvds and videogames have age restriction
			if (i instanceof Book){
				Book x = (Book) i;
				if (x.getAgeRestriction() == this.ageRestrictionToSearch){
					this.foundResults.add(x);
				}
			}
			if (i instanceof DVD){
				DVD x = (DVD) i;
				if (x.getAgeRestriction() == this.ageRestrictionToSearch){
					this.foundResults.add(x);
				}
			}
			if (i instanceof VideoGame){
				VideoGame x = (VideoGame) i;
				if (x.getAgeRestriction() == this.ageRestrictionToSearch){
					this.foundResults.add(x);
				}
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> mixedSearch(){
		
		if (this.foundResults.isEmpty()){
			if (! this.typeToSearch.equals("All")){
				this.foundResults = searchForType();
			}
			if (! this.genreToSearch.equals("All")){
				this.foundResults = searchForGenre();
			}
			if (! this.categoryToSearch.equals("All")){
				this.foundResults = searchForCategory();
			}
			if (this.ageRestrictionToSearch != 0){
				this.foundResults = searchForAgeRestriction();
			}
		}
		else {
			if (! this.typeToSearch.equals("All")){
				this.foundResults = crossedSearchForType();
			}
			if (! this.genreToSearch.equals("All")){
				this.foundResults = crossedSearchForGenre();
			}
			if (! this.categoryToSearch.equals("All")){
				this.foundResults = crossedSearchForCategory();
			}
			if (this.ageRestrictionToSearch != 0){
				this.foundResults = crossedSearchForAgeRestriction();
			}
		}
		
		return this.foundResults;
	}
	
	private ArrayList<Item> crossedSearchForType(){
		for (int i = this.foundResults.size() - 1; i >= 0; i--){
			if(! this.foundResults.get(i).getType().equals(typeToSearch)){
				this.foundResults.remove(i);
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> crossedSearchForGenre(){
		
		for (int i = this.foundResults.size() -1; i >= 0; i--){
			// Only CDs and DVDs have a genre
			Item item = this.foundResults.get(i);
			if (item instanceof CD){
				CD x = (CD) item;
				if (!x.getGenre().equals(this.genreToSearch)){
					this.foundResults.remove(i);
				}
			}
			if (item instanceof DVD){
				DVD x = (DVD) item;
				if (! x.getGenre().equals(this.genreToSearch)){
					this.foundResults.remove(i);
				}
			}
		}
		
		return this.foundResults;
	}
	
	private ArrayList<Item> crossedSearchForCategory(){
		boolean containsCategory = false; 
		
		for (int i = this.foundResults.size() - 1; i>=0; i--){
			for (String c : this.foundResults.get(i).getCategories()){
				if (c.equals(categoryToSearch)){
					containsCategory = true;
				}
			}
			if (!containsCategory){
				this.foundResults.remove(i);
			}
		}
		return this.foundResults;
	}
	
	private ArrayList<Item> crossedSearchForAgeRestriction(){
		
		for (int i = this.foundResults.size() -1 ; i >= 0; i--){
			Item item = this.foundResults.get(i);
			// Only books, dvds and videogames have age restriction.
			if (item instanceof Book){
				Book x = (Book) item;
				if (x.getAgeRestriction() != this.ageRestrictionToSearch){
					this.foundResults.remove(i);
				}
			}
			if (item instanceof DVD){
				DVD x = (DVD) item;
				if (x.getAgeRestriction() != this.ageRestrictionToSearch){
					this.foundResults.remove(i);
				}
			}
			if (item instanceof VideoGame){
				VideoGame x = (VideoGame) item;
				if (x.getAgeRestriction() != this.ageRestrictionToSearch){
					this.foundResults.remove(i);
				}
			}
		}
		
		return this.foundResults;
	}
	
	public ArrayList<Item> getSearchResulst(){
		return this.foundResults;
	}

	private void resetFilters(){
		setSearchForAuthor(false);
		setSearchForID(false);
		setSearchForTitle(false);
		setTypeToSearch("All");
		setGenreToSearch("All");
		setCategoryToSearch("All");
		setAgeRestrictionToSearch("All");
	}

	public boolean isSearchForID() {
		return searchForID;
	}

	public void setSearchForID(boolean searchForID) {
		this.searchForID = searchForID;
	}

	public boolean isSearchForTitle() {
		return searchForTitle;
	}

	public void setSearchForTitle(boolean searchForTitle) {
		this.searchForTitle = searchForTitle;
	}

	public boolean isSearchForAuthor() {
		return searchForAuthor;
	}

	public void setSearchForAuthor(boolean searchForAuthor) {
		this.searchForAuthor = searchForAuthor;
	}
	
	private void resetResults(){
		this.foundResults.clear();
	}
	
	public void onSearchFinished(){
		StaffFrame.showSearchResult(this.foundResults);
		resetResults();
		StaffFrame.resetSearchResult();
	}

	public String getTypeToSearch() {
		return typeToSearch;
	}

	public void setTypeToSearch(String typeToSearch) {
		this.typeToSearch = typeToSearch;
	}

	public String getGenreToSearch() {
		return genreToSearch;
	}

	public void setGenreToSearch(String genreToSearch) {
		this.genreToSearch = genreToSearch;
	}

	public String getCategoryToSearch() {
		return categoryToSearch;
	}

	public void setCategoryToSearch(String categoryToSearch) {
		this.categoryToSearch = categoryToSearch;
	}

	public int getAgeRestrictionToSearch() {
		return this.ageRestrictionToSearch;
	}

	public void setAgeRestrictionToSearch(String ageRestrictionToSearch) {
		if (ageRestrictionToSearch.equals("All")){
			this.ageRestrictionToSearch = 0;
		}
		else if (ageRestrictionToSearch.equals("+ 10 years old")){
			this.ageRestrictionToSearch = 10;
		}
		else if (ageRestrictionToSearch.equals("+ 12 years old")){
			this.ageRestrictionToSearch = 12;
		}
		else if (ageRestrictionToSearch.equals("+ 14 years old")){
			this.ageRestrictionToSearch = 14;
		}
		else if (ageRestrictionToSearch.equals("+ 16 years old")){
			this.ageRestrictionToSearch = 16;
		}
		else if (ageRestrictionToSearch.equals("+ 18 years old")){
			this.ageRestrictionToSearch = 18;
		}
		else{
			// Invalid age
			this.ageRestrictionToSearch = -1;
		}
	}
	
	public ArrayList<Item> returnAllDatabase(){
		for (Item i : this.databaseController.getItems()){
			this.foundResults.add(i);
		}
		return this.foundResults;
	}
	
	private void debugFoundResults(){
		for (Item i : this.foundResults){
			System.out.println(i.getTitle());
		}
	}
}
