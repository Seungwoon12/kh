package api.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test02_1 {
	public static void main(String[] args) throws IOException {
		//받는 프로그램 만들기
		
		//33333번 포트의 내용을 수신하는 우체국을 생성
		DatagramSocket ds = new DatagramSocket(33333);
		
		while(true) {
			//어느정도의 데이터를 수신할 것인지 미리 정한 다음 수신하도록 도구를 생성
			byte[] buffer = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);		
			
			//우체국(ds)을 이용하여 편지(dp)를 수신
			ds.receive(dp);
			
			//분석
			// - 내용 복원(String)
			// - 발신 정보 확인(보낸 대상의 IP, Port)
			String text = new String(dp.getData(), 0, dp.getLength());
			System.out.println("text = " + text);//문자로 치면 전송내용
			
			InetAddress addr = dp.getAddress();
			System.out.println("addr = " + addr);//IP 정보 객체
			int port = dp.getPort();
			System.out.println("port = " + port);//포트 정보
		}
		
		//우체국 폐쇄
		//ds.close();
	}
}