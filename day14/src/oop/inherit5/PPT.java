package oop.inherit5;

public final class PPT extends File{
	private int size = 1;

	public PPT(String filename) {
		super(filename);
	}

	@Override
	public void execute() {
		System.out.println("파워포인트 애니메이션을 재생합니다");
	}
	
	public void information() {
//		부모클래스 변수가 private일 경우 직접 접근이 불가하므로 이용 절차가 까다로워진다
//		System.out.println("이름 : "+this.filename);
//		System.out.println("이름 : "+super.filename);
		System.out.println("이름 : "+filename);
//		System.out.println("이름 : "+this.getFilename());
//		System.out.println("이름 : "+super.getFilename());
//		System.out.println("이름 : "+getFilename());
		
		System.out.println("크기 : "+filesize+"bytes");
		System.out.println("장수 : "+size+"장");
	}

}