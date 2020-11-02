package oop.basic1;
/**
 *	컴퓨터에게 메세지(Message)가 뭔지 알려주기 위한 구문
 *	- 메세지 	= 보낸사람 + 내용 + 보낸시각 + 안읽은숫자 
 *			= sender + text + time + read
 *			= String + String + String + int 
 *
 *	이러한 구문이 있을 경우 자바는 Message라는 글자를 하나의 형태(Data Type)로 인식하게 되며
 *	데이터 4개가 조합되었다는 것을 이해하고 그에 맞게 준비를 해준다.
 */
public class Message {
	String sender;
	String text;
	String time;
	int read;
}