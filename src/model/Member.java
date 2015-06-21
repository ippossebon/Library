package model;

public class Member {
	
	private String name;
	private int age;
	private String password;
	
	public Member(String name, int age, String password){
		this.setName(name);
		this.setAge(age);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
