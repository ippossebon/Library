package controller;

import model.Item;
import model.Member;

public class Request {

	private Member member;
	private Item item;
	
	public Request(Member member, Item item){
		this.setMember(member);
		this.setItem(item);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
