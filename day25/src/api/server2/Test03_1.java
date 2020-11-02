package api.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		//서버 코드
		ServerSocket server = new ServerSocket(33333);
		Socket socket = server.accept();
		System.out.println("socket = " + socket);
		
		//입력도구를 만들어서 사용자가 보내는 메세지를 무한대로 수신
		//- 종료조건 : "종료"라는 값이 들어오면 더이상 메세지를 수신하지 않는다!
		InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String line = br.readLine();
			System.out.println("line = " + line);
			
//			if(line == "종료") {//이건 안됨
//			if(line != null && line.equals("종료")) {//null이 아니면서 종료일 때
			if(line == null || line.equals("종료")) {//null이거나 종료일 때
				break;
			}
		}
		
		socket.close();
		server.close();
	}
}