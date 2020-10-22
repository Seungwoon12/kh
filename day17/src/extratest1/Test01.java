package extratest1;

public class Test01 {
	public static void main(String[] args) {
		
		Score[] student = new Score[3];
		student[0] = new Score("이오리", 80, 70);
		student[1] = new Score("김갑환", 70, 90);
		student[2] = new Score("최번개", 100, 45);
		
		System.out.println(student.length);
		
		
		for(int i=0; i<student.length; i++) {
			
			int total = student[i].getJava() + student[i].getJsp();
			double average = (double)total / (student.length - 1);
			
			System.out.println("총점 : "+ total +" 평균: "+average);
		}
		
	}
}
