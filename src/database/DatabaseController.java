package database;

import java.util.ArrayList;

import model.Item;
import model.Member;
import model.Rent;
import model.Request;
import model.RequestedItem;
import model.Staff;
import model.SuperStaff;

public class DatabaseController {
	private Database database;
	private ArrayList<Rent> currentRentedItems;
	private ArrayList<Request> requestedItems;
	private ArrayList<RequestedItem> newItemsRequested;
	
	public DatabaseController(){
		setDatabase(new Database());
		setCurrentRentedItems(new ArrayList<Rent>());
		setRequestedItems(new ArrayList<Request>());
		setNewItemsRequested(new ArrayList<RequestedItem>());
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public ArrayList<Rent> getCurrentRentedItems() {
		return currentRentedItems;
	}

	public void setCurrentRentedItems(ArrayList<Rent> currentRentedItems) {
		this.currentRentedItems = currentRentedItems;
	}
	
	public void addRentedItem(Rent rent){
		this.currentRentedItems.add(rent);
	}
	
	public void removeRentedItemFromList (Item item){
		for (Rent r : this.currentRentedItems){
			if (r.getItem().getId() == item.getId()){
				this.currentRentedItems.remove(r);
			}
		}
	}

	public ArrayList<Request> getRequestedItems() {
		return requestedItems;
	}

	public void setRequestedItems(ArrayList<Request> requestedItems) {
		this.requestedItems = requestedItems;
	}
	
	public ArrayList<Item> getItems() {
		return this.database.getItems();
	}

	public void addItemToDatabase(Item item) {
		this.database.addItem(item);
	}

	public ArrayList<Member> getMembers() {
		return this.database.getMembers();
	}
	
	public void addMemberToDatabase(Member member){
		this.database.addMember(member);
	}

	public ArrayList<Staff> getStaffList() {
		return this.database.getStaff();
	}

	public void addStaffToDatabase(Staff staff){
		this.database.addStaff(staff);
	}
	
	public ArrayList<SuperStaff> getSuperStaffList() {
		return this.database.getSuperStaff();
	}

	public int checkLogin(String name, String password){
		
		for (Staff staff : this.database.getStaff()){
		
			if (staff.getName().equals(name)){
			
				if (staff.getPassword().equals(password)){
				
					return this.database.STAFF;
				}
			}
		}
		
		for (SuperStaff ss : this.database.getSuperStaff()){
		
			if (ss.getName().equals(name)){
			
				if (ss.getPassword().equals(password)){
				
					return this.database.SUPER_STAFF;
				}
			}
		}
		
		for (Member m : this.getMembers()){
			if (m.getName().equals(name)){
				if (m.getPassword().equals(password)){
					return this.database.MEMBER;
				}
			}
		}
		
		return -1;
	}

	public ArrayList<String> getCategoriesFromDatabase(){
		return this.database.getCategories();
	}
	
	public ArrayList<String> getGenresFromDatabase(){
		return this.database.getGenres();
	}
	
	public Item getItemFromId(String id){
		return this.database.getItemFromId(id);
	}
	
	public Item getItemFromTitle (String title){
		return this.database.getItemFromTitle(title);
	}
	
	public Member getMemberByName (String name){
		return this.database.getMemberByName(name);
	}
	
	public boolean isMemberOnDatabase(String name){
		return this.database.isMemberOnDatabase(name);
	}
	
	public void addRequest(Request request){
		this.requestedItems.add(request);
	}
	
	// Returns true if the id is unique.
	public boolean isIDValid(String id){
		for (Item i : this.database.getItems()){
			if (i.getId().equals(id)){
				return false;
			}
		}
		return true;
	}
	
	public void removeItemFromDatabase(String title){
		for (int i = this.database.getItems().size() - 1; i >= 0; i--){
			if (this.database.getItems().get(i).getTitle().equals(title)){
				this.database.getItems().remove(i);
			}
		}
	}
	
	public boolean isNewCategory(String category){
		for (String c: this.database.getCategories()){
			if (c.toLowerCase().equals(category.toLowerCase())){
				return false;
			}
		}
		return true;
	}
	
	public boolean isNewGenre(String genre){
		for (String g : this.database.getGenres()){
			if (g.toLowerCase().equals(genre.toLowerCase())){
				return false;
			}
		}
		return true;
	}
	
	public void addCategoryToDatabase(String category){
		if (isNewCategory(category)){
			this.database.getCategories().add(category);
		}
	}
	
	public void addGenreToDatabase(String genre){
		if (isNewGenre(genre)){
			this.database.getGenres().add(genre);
		}
	}
	
	public void showDatabase(){
		for (Item i : this.database.getItems()){
			System.out.println("-----------------------------------------------------");
			System.out.println ("Title: " + i.getTitle() + " Author: " + i.getAuthor());
			System.out.println("Categories: ");
			for (String c : i.getCategories()){
				System.out.println(c);
			}
		}
	}

	public ArrayList<RequestedItem> getNewItemsRequested() {
		return this.newItemsRequested;
	}

	public void setNewItemsRequested(ArrayList<RequestedItem> newItemsRequested) {
		this.newItemsRequested = newItemsRequested;
	}
	
	public boolean isNewRequestedItem(RequestedItem item){
		for (RequestedItem r : this.newItemsRequested){
			if (r.getTitle().equals(item.getTitle())){
				if(r.getAuthor().equals(item.getAuthor())){
					if (r.getType().equals(item.getType())){
						return false;
					}
				}	
			}
		}
		return true;
	}
	public void addNewRequestedItem(RequestedItem item){
		if (isNewRequestedItem(item)){
			this.newItemsRequested.add(item);
		}	
	}
	
	public boolean containsItem(String title, String author, String type){
		for (Item i : this.database.getItems()){
			if (i.getTitle().equals(title)){
				if (i.getAuthor().equals(author)){
					if (i.getType().equals(type)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void printRequestedItems(){
		for (RequestedItem r : this.newItemsRequested){
			System.out.println("Type: " + r.getType() + " Title: " + r.getTitle() + " Author: " + r.getAuthor());
		}
	}
}
