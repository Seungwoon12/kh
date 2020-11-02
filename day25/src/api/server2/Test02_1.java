package api.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02_1 {
	public static void main(String[] args) throws IOException {
		//목표 : 서버 생성 후 사용자가 접속하면 문장 1개(String)를 입력받고 연결종료
		ServerSocket server = new ServerSocket(33333);
		Socket socket = server.accept();
		System.out.println("socket = " + socket);
		
		//문장 입력을 받기 위한 스트림을 준비
		//- InputStreamReader : InputStream을 원하는 형태의 글꼴로 변환하여 읽는 도구(FileReader 대신)
		InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine();
		System.out.println("line = " + line);
		
		//br.close();
		socket.close();
		server.close();
	}
}