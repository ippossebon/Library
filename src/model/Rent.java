package model;

public class Rent {
	private Member member;
	private Item item;
	
	public Rent(Member m, Item i){
		this.setMember(m);
		this.setItem(i);
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
