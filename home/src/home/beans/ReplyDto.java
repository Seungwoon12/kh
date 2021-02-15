package home.beans;

import java.sql.Date;

public class ReplyDto {
	private int reply_no;
	private String reply_content;
	private Date reply_time;
	private int reply_origin;
	private String reply_writer;
	public ReplyDto() {
		super();
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_time() {
		return reply_time;
	}
	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
	public int getReply_origin() {
		return reply_origin;
	}
	public void setReply_origin(int reply_origin) {
		this.reply_origin = reply_origin;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
}
