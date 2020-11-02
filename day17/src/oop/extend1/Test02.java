package oop.extend1;

public class Test02 {
	public static void main(String[] args) {
		//출력을 반복문으로 처리
		Student[] stu = new Student[3];
		
		stu[0] = new Student("이오리", 80, 70);
		stu[1] = new Student("김갑환", 70, 90);
		stu[2] = new Student("최번개", 100, 45);
		
		for(int i=0; i < stu.length; i++) {
			stu[i].print();
		}
	}
}
