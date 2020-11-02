package api.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) throws IOException {
//		통신을 하려면 반드시 프로그램이 2개가 실행되어야 한다
//		- 보내는 프로그램(sender)
//		- 받는 프로그램(receiver)
		
//		보내는 프로그램 만들기
//		- 문자 또는 우편과 유사한 방식의 통신인 UDP 방식을 구현
//		- DatagramSocket : 전송 도구(우체국)
//		- DatagramPacket : 전송할 데이터(편지) : 받을 사람의 주소(IP, Port) + 내용(String)
		
		String text = "안녕하세요!";
		
		DatagramSocket ds = new DatagramSocket();
//		DatagramPacket dp = new DatagramPacket(내용, 크기, IP, Port);
		DatagramPacket dp = new DatagramPacket(
				text.getBytes(), 
				text.getBytes().length, 
				InetAddress.getByName("127.0.0.1"), 
				33333
			);
		
//		우체국(ds)을 이용해서 편지지(dp)를 전송한다
		ds.send(dp);
		
//		우체국 영업 종료
		ds.close();
	}
}
