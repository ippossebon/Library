package controller;

import model.Book;
import model.DVD;
import model.Item;
import model.Member;
import model.Rent;
import model.VideoGame;
import database.DatabaseController;

// Allows staff to loan an item.
// Allows staff to check which member has which item.
public class LoanController {

	private Item itemToRent;
	private Member member;
	private DatabaseController databaseController;
	
	public LoanController(DatabaseController databaseController){
		this.databaseController = databaseController;
	}
	
	public void setItemToRent(String titleToRent){
		this.itemToRent = this.databaseController.getItemFromTitle(titleToRent);
	}

	public Item getItemToRent() {
		return itemToRent;
	}

	public void setItemToRent(Item itemToRent) {
		this.itemToRent = itemToRent;
	}
	
	public boolean isItemAvailable(){
		return this.itemToRent.isAvailable();
	}
	
	public void setMember(String name){
		this.member = this.databaseController.getMemberByName(name);
	}
	
	public boolean isMemberOnDatabase(String name){
		return this.databaseController.isMemberOnDatabase(name);
	}
	
	public Member getMember(){
		return this.member;
	}
	
	public boolean isMemberOldEnough(){
		// Check if the age restriction is satisfiable.
		
		if (this.itemToRent instanceof Book){
			Book book = (Book) this.itemToRent;
			if (this.member.getAge() >= book.getAgeRestriction()){
				return true;
			}
		}
		else if (this.itemToRent instanceof DVD){
			DVD dvd = (DVD) this.itemToRent;
			if (this.member.getAge() >= dvd.getAgeRestriction()){
				return true;
			}
		}
		else if (this.itemToRent instanceof VideoGame){
			VideoGame game = (VideoGame) this.itemToRent;
			if (this.member.getAge() >= game.getAgeRestriction()){
				return true;
			}
		}
		return false;
	}

	public void loan(){
		Rent rent = new Rent(this.member, this.itemToRent);
		this.databaseController.addRentedItem(rent);
		this.itemToRent.setAvailable(false);
		for (Rent r : this.databaseController.getCurrentRentedItems()){
			System.out.println("Item: " + r.getItem().getTitle());
			System.out.println("Member: " + r.getMember().getName());
		}
	}
}
