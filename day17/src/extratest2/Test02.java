package extratest2;

public class Test02 {
	public static void main(String[] args) {
		//갤럭시 5개 생성(반복문 사용)
		
		GalaxyNote20[] list = new GalaxyNote20[5];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new GalaxyNote20("010-1234-5678");
		}
		
		for(int i=0; i<list.length; i++) {
			list[i].call();
			list[i].text();
		}
	
		
		
	}
}
