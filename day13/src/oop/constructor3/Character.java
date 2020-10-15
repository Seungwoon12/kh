package oop.constructor3;

public class Character {
	String id;
	String job;
	int level;
	int money;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public void setJob(String job) {
		if(job == "전사" || job == "마법사") {
			this.job = job;
		}
		else {
			return;
		}
		
	}
	public String getJob() {
		return this.job;
	}
	public void setLevel(int level) {
		if(level < 1) {
			return;
		}
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}
	public void setMoney(int money) {
		if(money < 0) {
			return;
		}
		this.money = money;
	}
	public int getMoney() {
		return this.money;
	}
	
	public Character(String id, String job) {
		this(id, job, 1, 0);
		
//		this.setId(id);
//		this.setJob(job);
//		this.setLevel(1);
//		this.setMoney(0);
	}
	public Character(String id, String job, int level, int money) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setMoney(money);
		
	}
	
	public void print() {
		System.out.println("아이디 : "+this.id);
		System.out.println("직업 : "+this.job);
		System.out.println("레벨 : "+this.level);
		System.out.println("소지금 : "+this.money);
		
	}
}
