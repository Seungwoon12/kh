package mvc.controller;

//주소를 이용하여 컨트롤러를 생성하는 클래스
public class ControllerFactory {
	public static Controller create(String url) {
		switch(url) {
		case "/board/detail.do": return new BoardDetailController();
		case "/board/list.do": return new BoardListController();
		case "/board/write.do": return new BoardWriteController();
		case "/board/edit.do": return new BoardEditController();
		default: return null;
		}
	}
}