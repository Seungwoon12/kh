package extratest2;

public class Test01 {
	public static void main(String[] args) {
		//갤럭시 5개 생성(no반복문)
		GalaxyNote20[] p1 = new GalaxyNote20[5];
		
		p1[0] = new GalaxyNote20("010-1234-5678");
		p1[1] = new GalaxyNote20("010-1203-1231");
		p1[2] = new GalaxyNote20("010-2134-1241");
		p1[3] = new GalaxyNote20("010-1234-1245");
		p1[4] = new GalaxyNote20("010-1234-1240");
		
		p1[0].call();	p1[0].text();
		p1[1].call();	p1[1].text();
		p1[2].call();	p1[2].text();
		p1[3].call();	p1[3].text();
		p1[4].call();	p1[4].text();
	}
}
