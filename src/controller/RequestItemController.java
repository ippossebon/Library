package controller;

import model.Book;
import model.DVD;
import model.Item;
import model.Member;
import model.Request;
import model.VideoGame;

public class RequestItemController {

	private Item item;
	private Member member;
	
	public RequestItemController(){
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public void setMember(String name){
		this.member = Main.getDatabaseController().getMemberByName(name);
	}
	
	public boolean isMemberOnDatabase(){
		return Main.getDatabaseController().isMemberOnDatabase(this.member.getName());
	}
	
	public boolean isMemberOldEnough(){
		// Check if the age restriction is satisfiable.	
		if (this.item instanceof Book){
			Book book = (Book) this.item;
			if (this.member.getAge() >= book.getAgeRestriction()){
				return true;
			}
			return false;
		}
		else if (this.item instanceof DVD){
			DVD dvd = (DVD) this.item;
			if (this.member.getAge() >= dvd.getAgeRestriction()){
				return true;
			}
			return false;
		}
		else if (this.item instanceof VideoGame){
			VideoGame game = (VideoGame) this.item;
			if (this.member.getAge() >= game.getAgeRestriction()){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public void request(){
		Request request = new Request(this.member, this.item);
		Main.getDatabaseController().addRequest(request);
		
		System.out.println("Requests: ");
		for (Request r : Main.getDatabaseController().getRequestedItems()){
			System.out.println("Item: " + r.getItem().getTitle());
			System.out.println("Member: "+ r.getMember().getName());
		}
	}
}
