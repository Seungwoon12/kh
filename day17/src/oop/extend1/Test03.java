package oop.extend1;

public class Test03 {
	public static void main(String[] args) {
		//입력을 반복문으로 처리
		// - 입력을 반복문으로 처리하려면 이름, 점수에 대한 배열이 따로 있어야 한다
		String[] nameList = new String[] {"이오리", "김갑환", "최번개"};
		int[] javaList = new int[] {80, 70, 100};
		int[] jspList = new int[] {70, 90, 45};
		
		Student[] stu = new Student[3];
		
		for(int i=0; i<stu.length; i++) {
			stu[i] = new Student(nameList[i], javaList[i], jspList[i]);
		}
		
		for(int i=0; i < stu.length; i++) {
			stu[i].print();
		}
	}
}