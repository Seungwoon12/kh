package oop.extend1;

public class Test01 {
	public static void main(String[] args) {
		//반복문 없이 풀이
		Student[] stu = new Student[3];
		
		stu[0] = new Student("이오리", 80, 70);
		stu[1] = new Student("김갑환", 70, 90);
		stu[2] = new Student("최번개", 100, 45);
		
		stu[0].print();
		stu[1].print();
		stu[2].print();
	}
}
