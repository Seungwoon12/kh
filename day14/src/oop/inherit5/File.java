package oop.inherit5;

public class File {
	//멤버 변수 : 접근제한
	protected String filename;
	protected long filesize;//int면 2GB까지밖에 표현이 안됨
	
	//생성자 : 필수항목
	public File(String filename) {
		this.setFilename(filename);
		//this.setFilesize(0L);
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
	//메소드 : 재정의(override) 여부를 신중하게 결정
	// - 뭐라고 코드를 작성하던 간에 각자의 클래스에서 수정해야 함(모든 클래스가 다른 내용을 가짐)
	// - final을 작성하면 안된다
	public void execute() {
		//쓸 코드가 없음(어짜피 고칠텐데...)
	}
	
}