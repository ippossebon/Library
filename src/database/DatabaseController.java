package database;

import java.util.ArrayList;

import model.Item;
import model.Member;
import model.Staff;
import model.SuperStaff;

public class DatabaseController {
	private Database database;
	private ArrayList<Item> currentRentedItems;
	private ArrayList<Item> requestedItems;
	
	public DatabaseController(){
		setDatabase(new Database());
		setCurrentRentedItems(new ArrayList<Item>());
		setRequestedItems(new ArrayList<Item>());
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public ArrayList<Item> getCurrentRentedItems() {
		return currentRentedItems;
	}

	public void setCurrentRentedItems(ArrayList<Item> currentRentedItems) {
		this.currentRentedItems = currentRentedItems;
	}

	public ArrayList<Item> getRequestedItems() {
		return requestedItems;
	}

	public void setRequestedItems(ArrayList<Item> requestedItems) {
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
}
