package com.kh.spring11;

public class Student {
	private String student_name;
	private int student_score;
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_score() {
		return student_score;
	}
	public void setStudent_score(int student_score) {
		this.student_score = student_score;
	}
	public Student() {
		super();
	}
}