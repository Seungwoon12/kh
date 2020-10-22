package oop.multi3;

public class Galaxy20s implements Phone, Game, MusicPlayer, Camera  {

	@Override
	public void photo() {
		System.out.println("갤럭시의 카메라 기능을 실행합니다.");
		
	}

	@Override
	public void music() {
		System.out.println("갤럭시의 음악재생 기능을 실행합니다.");
		
	}

	@Override
	public void play() {
		System.out.println("갤럭시의 게임 기능을 실행합니다.");
		
	}

	@Override
	public void call() {
		System.out.println("갤럭시의 전화 기능을 실행합니다.");
		
	}

	@Override
	public void sms() {
		System.out.println("갤럭시의 문자 기능을 실행합니다.");
		
	}
	
	


}
