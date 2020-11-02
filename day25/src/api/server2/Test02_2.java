package api.server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test02_2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//목표 : 서버에 접속한 뒤 문장 1개를 서버에 전송하고 연결을 종료
		
		//InetAddress addr = InetAddress.getByName("127.0.0.1");
		String addr = "127.0.0.1";
		int port = 33333;
		Socket socket = new Socket(addr, port);
		
		//문장을 전송하기위한 준비
		//- OutputStreamWriter : socket의 출력부에 연결하여 내보낼 수 있는 writer(인코딩 지정 가능)
		OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw, 8192);
		PrintWriter pw = new PrintWriter(bw);
		
		//[프로그램] → pw → bw → osw → socket.getOutputStream() → 네트워크
		pw.println("TCP 통신이 잘 되네요");
		pw.flush();//파일 통신과의 차이점 : 네트워크는 실시간 전송이 생명!(무조건 출력 후 flush를 수행)
		
		//연결 종료
		socket.close();
		
	}
}
