package home.beans;

import java.sql.Date;

//MemberDto에 rank 정보를 추가 저장할 수 있는 클래스
//= DTO와 다르게 내가 지금 사용할 정보를 작성하여 용도에 맞게 사용한다
public class MemberRankVO {
	private int member_no;
	private String member_id;
	private String member_nick;
	private String member_auth;
	private int member_point;
	private Date member_join;
	private int rank;
	public MemberRankVO() {
		super();
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_auth() {
		return member_auth;
	}
	public void setMember_auth(String member_auth) {
		this.member_auth = member_auth;
	}
	public int getMember_point() {
		return member_point;
	}
	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}
	public Date getMember_join() {
		return member_join;
	}
	public void setMember_join(Date member_join) {
		this.member_join = member_join;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}