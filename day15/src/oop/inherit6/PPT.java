package oop.inherit6;

public class PPT extends File {
	private int size = 1;
	
	public PPT(String filename) {
		super(filename);
	}

	@Override
	public void execute() {
		System.out.println("파워포인트 애니메이션을 실행합니다!");
	}
	//information 생략
	
}