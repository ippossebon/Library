package model;

public class Rent {
	private Member member;
	private Item item;
	private int duration;
	
	public Rent(Member m, Item i, int duration){
		this.setMember(m);
		this.setItem(i);
		this.setDuration(duration);
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
