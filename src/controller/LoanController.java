package controller;

import view.UserFrame;
import model.Book;
import model.DVD;
import model.Item;
import model.Member;
import model.Rent;
import model.VideoGame;
import database.DatabaseController;

public class LoanController {

	private Item itemToRent;
	private Member member;
	
	public LoanController(){
		
	}
	
	public void setItemToRent(String titleToRent){
		this.itemToRent = Main.getDatabaseController().getItemFromTitle(titleToRent);
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
		this.member = Main.getDatabaseController().getMemberByName(name);
	}
	
	public boolean isMemberOnDatabase(String name){
		return Main.getDatabaseController().isMemberOnDatabase(name);
	}
	
	public Member getMember(){
		return this.member;
	}
	
	public boolean isMemberOldEnough(){
		// Check if the age restriction is satisfiable.
		
		if (this.itemToRent instanceof Book){
			Book book = (Book) this.itemToRent;
			if (this.member.getAge() < book.getAgeRestriction()){
				return false;
			}
		}
		else if (this.itemToRent instanceof DVD){
			DVD dvd = (DVD) this.itemToRent;
			if (this.member.getAge() < dvd.getAgeRestriction()){
				return false;
			}
		}
		else if (this.itemToRent instanceof VideoGame){
			VideoGame game = (VideoGame) this.itemToRent;
			if (this.member.getAge() < game.getAgeRestriction()){
				return false;
			}
		}
		return true;
	}

	public void loan(){
		Rent rent = new Rent(this.member, this.itemToRent);
		Main.getDatabaseController().addRentedItem(rent);
		this.itemToRent.setAvailable(false);
		for (Rent r : Main.getDatabaseController().getCurrentRentedItems()){
			System.out.println("Item: " + r.getItem().getTitle());
			System.out.println("Member: " + r.getMember().getName());
		}
	}
}
