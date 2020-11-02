package api.server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_1 {
	public static void main(String[] args) throws IOException {
		//TCP Server 구현
		//- 서버를 만들겠다는건 접속을 받겠다는 뜻이므로 상대방이 알 수 있는 IP와 Port를 지정해야 한다.
		//- ServerSocket : 접속을 받을 수 있는 도구(가게, 전화, ...)
		
		//서버 개방 코드
		ServerSocket server = new ServerSocket(33333);
		System.out.println("서버가 실행되었습니다");
		
		//연결 수신 코드(=Socket을 얻어낸다)
		Socket socket = server.accept();
		System.out.println("사용자가 접속했습니다!");
		System.out.println(socket);
		
		//연결 이후에 하고싶은 작업을 수행
		
		//연결 종료
		socket.close();//1명의 연결을 종료
		server.close();//전체 서버 종료
	}
}