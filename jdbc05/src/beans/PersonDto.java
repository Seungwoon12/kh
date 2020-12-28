package beans;

import java.sql.Date;

//person 테이블에 들어가거나 나오는 정보를 포장하기 위한 클래스
//dto는 data transfer object라고 하며 변환 객체라고 부른다
//과거 클래스 때 엄청 많이 만들었던 유형의 클래스
//데이터베이스와 항목이 똑같이 있어야 한다

public class PersonDto {
	private int person_no;
	private String person_name;
	private int javascore;
	private int dbscore;
	private String gender;
	private Date regist_date;
	
	
	public PersonDto() {
		super();
		
	}
	
	
	public int getPerson_no() {
		return person_no;
	}

	public void setPerson_no(int person_no) {
		this.person_no = person_no;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public int getJavascore() {
		return javascore;
	}

	public void setJavascore(int javascore) {
		this.javascore = javascore;
	}

	public int getDbscore() {
		return dbscore;
	}

	public void setDbscore(int dbscore) {
		this.dbscore = dbscore;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

	
}
