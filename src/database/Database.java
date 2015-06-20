package database;

import java.util.ArrayList;

import model.Book;
import model.CD;
import model.DVD;
import model.Document;
import model.Item;
import model.Member;
import model.Staff;
import model.SuperStaff;
import model.VideoGame;

public class Database {

	public static final int STAFF = 0;
	public static final int SUPER_STAFF = 1;
	
	private ArrayList<Item> items;
	private ArrayList<Member> members;
	private ArrayList<Staff> staff;
	private ArrayList<SuperStaff> superStaff;
	private ArrayList<String> categories;
	private ArrayList<String> genres;
	
	public Database(){
		
		this.setItems(new ArrayList<Item>());
		this.setCategories(new ArrayList<String>());
		this.setGenres(new ArrayList<String>());
		this.setMembers(new ArrayList<Member>());
		this.setStaff(new ArrayList<Staff>());
		this.setSuperStaff(new ArrayList<SuperStaff>());
		
		// Add data to database.
		Member member1 = new Member("Alan Turing", 30);
		this.addMember(member1);
		Member member2 = new Member("Stephen Hawking", 73);
		this.addMember(member2);
		Member member3 = new Member("Sheldon Cooper", 5);
		this.addMember(member3);
		Member member4 = new Member("Penny", 28);
		this.addMember(member4);
		Member member5 = new Member("Leonard Hofstadter", 29);
		this.addMember(member5);
		Member member6 = new Member("Amy Farrah Fowler", 15);
		this.addMember(member6);
	
		Staff staff1 = new Staff("Rachel Greene", "barneys");
		this.addStaff(staff1);
		Staff staff2 = new Staff("Phoebe Buffay", "smellycat22");
		this.addStaff(staff2);
		Staff staff3 = new Staff("Monica Geller", "clean4ever");
		this.addStaff(staff3);
		Staff staff4 = new Staff("Chandler Bing", "chanandlerbong");
		this.addStaff(staff4);
		Staff staff5 = new Staff("Ross Geller", "dinossaurs");
		this.addStaff(staff5);
		Staff staff6 = new Staff("Joey Tribiani", "2pizza");
		this.addStaff(staff6);
		Staff staff7 = new Staff("staff", "staff");
		this.addStaff(staff7);
		
		SuperStaff super1 = new SuperStaff("Batman", "theNight");
		this.addSuperStaff(super1);
		SuperStaff super2 = new SuperStaff("Spider Man", "marvel");
		this.addSuperStaff(super2);
		SuperStaff admin = new SuperStaff("admin", "admin");
		this.addSuperStaff(admin);
		
		ArrayList<String> book1Categories = new ArrayList<String>();
		book1Categories.add("Fantasy");
		Item book1 = new Book("Joanne Jo Rowling", "Harry Potter and the Philosopher's Stone", "b1", 12, book1Categories);
		this.addItem(book1);
		
		ArrayList<String> book2Categories = new ArrayList<String>();
		book2Categories.add("Fantasy");
		Item book2 = new Book("Joanne Jo Rowling", "Harry Potter and the Chamber of Secrets", "b2", 12, book2Categories);
		this.addItem(book2);
		
		ArrayList<String> book3Categories = new ArrayList<String>();
		book3Categories.add("Romance");
		book3Categories.add("Drama");
		Item book3 = new Book("E. L. James", "Fifty shades of Grey", "b3", 18, book3Categories);
		this.addItem(book3);
		
		ArrayList<String> book4Categories = new ArrayList<String>();
		book4Categories.add("Fantasy");
		Item book4 = new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", "b42", 10, book4Categories);
		this.addItem(book4);
		
		ArrayList<String> book5Categories = new ArrayList<String>();
		book5Categories.add("Drama");
		Item book5 = new Book("Joanne Jo Rowling", "The Casual Vacancy", "b5", 10, book5Categories);
		this.addItem(book5);
		
		ArrayList<String> cd1Categories = new ArrayList<String>();
		cd1Categories.add("CD");
		Item cd1 = new CD("Nickelback", "All the right reasons",  "cd1", "Rock", cd1Categories);
		this.addItem(cd1);
		
		ArrayList<String> cd2Categories = new ArrayList<String>();
		cd2Categories.add("CD");
		Item cd2 = new CD("U2", "Vertigo", "cd2", "Rock", cd2Categories);
		this.addItem(cd2);
		
		ArrayList<String> cd3Categories = new ArrayList<String>();
		cd3Categories.add("CD");
		Item cd3 = new CD("Beyoncé", "4", "cd3", "Rock", cd3Categories);
		this.addItem(cd3);
		
		ArrayList<String> cd4Categories = new ArrayList<String>();
		cd4Categories.add("CD");
		Item cd4 = new CD("Luan Santana", "O nosso tempo é hoje", "cd4", "International", cd4Categories);
		this.addItem(cd4);
		
		ArrayList<String> doc1Categories = new ArrayList<String>();
		doc1Categories.add("Biology");
		doc1Categories.add("Research");
		Item doc1 = new Document("F. W. Smith", "The life of the bees", "doc1", doc1Categories);
		this.addItem(doc1);
		
		ArrayList<String> doc2Categories = new ArrayList<String>();
		doc1Categories.add("Networking");
		doc1Categories.add("Computer Science");
		Item doc2 = new Document("S. K. Lil", "Cloud computing", "doc2", doc2Categories);
		this.addItem(doc2);
		
		ArrayList<String> dvd1Categories = new ArrayList<String>();
		dvd1Categories.add("Science Fiction");
		Item dvd1 = new DVD("Joel Silver", "Matrix", "dvd1", 12, "Science Fiction", dvd1Categories);
		this.addItem(dvd1);
		
		ArrayList<String> dvd2Categories = new ArrayList<String>();
		dvd2Categories.add("Drama");
		Item dvd2 = new DVD("Morten Tyldum", "The Imitation Game","dvd2", 14, "Drama", dvd2Categories);
		this.addItem(dvd2);
		
		ArrayList<String> game1Categories = new ArrayList<String>();
		game1Categories.add("Action");
		Item videogame1 = new VideoGame("Rockstar Games", "Grand Theft Auto V", "game1", 18, game1Categories);
		this.addItem(videogame1);
		
		ArrayList<String> game2Categories = new ArrayList<String>();
		game2Categories.add("Simulation");
		Item videogame2 = new VideoGame("EA Games", "The Sims 4", "game2", 14, game2Categories);
		this.addItem(videogame2);
		
		ArrayList<String> game3Categories = new ArrayList<String>();
		game3Categories.add("Simulation");
		Item videogame3 = new VideoGame("Atari", "Roller Coaster Tycoon 3", "game3", 10, game3Categories);
		this.addItem(videogame3);
		
		fillCategoriesList();
		fillGenresList();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	public ArrayList<SuperStaff> getSuperStaff() {
		return superStaff;
	}

	public void setSuperStaff(ArrayList<SuperStaff> superStaff) {
		this.superStaff = superStaff;
	}
	
	public void addItem(Item i){
		this.items.add(i);
	}
	
	public void addMember(Member m){
		this.members.add(m);
	}
	
	public void addStaff(Staff s){
		this.staff.add(s);
	}
	
	public void addSuperStaff(SuperStaff s){
		this.superStaff.add(s);
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
	
	private void fillCategoriesList(){
		for (Item item : this.items){
			for (String category : item.getCategories()){
				if (!this.categories.contains(category)){
					this.categories.add(category);
				}
			}
		}
	}
	
	private void fillGenresList(){
		for (Item item : this.items){
			if (item instanceof CD){
				CD cd = (CD) item;
				if (! this.genres.contains(cd.getGenre())){
					this.genres.add(cd.getGenre());
				}
			}
			else if (item instanceof DVD){
				DVD dvd = (DVD) item;
				if (! this.genres.contains(dvd.getGenre())){
					this.genres.add(dvd.getGenre());
				}
			}
		}
	}
	
	public Item getItemFromId(String id){
		for (Item item : this.items){
			if (item.getId().equals(id))
				return item;
		}
		return null;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	
	public Item getItemFromTitle(String title){
		for (Item item : this.items){
			if (item.getTitle().equals(title)){
				return item;
			}	
		}
		return null;
	}
	
	public Member getMemberByName(String name){
		for (Member m : this.members){
			if (m.getName().equals(name)){
				return m;
			}
		}
		return null;
	}
	
	public boolean isMemberOnDatabase(String name){
		for (Member m : this.members){
			if (m.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
}
