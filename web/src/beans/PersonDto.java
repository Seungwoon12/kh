package beans;

import java.sql.Date;

public class PersonDto {
	private int person_no;
	private String person_name;
	private int javascore;
	private int dbscore;
	private String gender;
	private Date regist_date;
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
	//가상의 getter 추가
	public int getTotal() {
		return javascore + dbscore;
	}
	public double getAverage() {
		return getTotal() / 2.0;
	}
	
	public PersonDto() {
		super();
	}
}
