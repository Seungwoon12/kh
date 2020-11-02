package oop.constructor3;

//플레이어 클래스 = 아이디 + 직업 + 레벨 + 소지금
public class Player {
	private String id;
	private String job;
	private int level;
	private int gold;
	
	//생성자 2개  
	// - 생성자를 여러 개 만들면 생성자 오버로딩(overloading)이라고 한다
	public Player(String id, String job) {//(ooxx)
		this(id, job, 1, 0);//매개변수 4개짜리 생성자를 부르는 구문
//		this.id = id;
//		this.job = job;
//		this.level = 1;
//		this.gold = 0;
	}
	public Player(String id, String job, int level, int gold) {//(oooo)
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setGold(gold);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		switch(job) {
		case "전사":
		case "마법사":
			this.job = job;
		}
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level < 1) {
			return;
		}
		this.level = level;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		if(gold < 0) {
			return;
		}
		this.gold = gold;
	}
	
	public void print() {
		System.out.println("아이디 : "+this.id);
		System.out.println("직업 : "+this.job);
		System.out.println("레벨 : "+this.level);
		System.out.println("소지금 : "+this.gold+"gold");
	}
}