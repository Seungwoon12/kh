package array;

public class Test08 {
	public static void main(String[] args) {
		// 배열의 위치 조작을 배워보자!
		// 기존에는 데이터를 한번 넣으면 계속 그 자리에 놔뒀었지만
		// 지금은 데이터의 위치를 서로 바꾸는 작업을 수행해본다~
		
		int[] data = new int[] {81,77,23,33,56,49};
		
		//어떻게 하면 77과 56을 서로 바꿀 수 있을까?
		//맞교환은 불가능(덮어쓰기가 됨)
		//둘 중 하나를 미리 다른곳으로 빼야한다(임시 변수 	필요)
	
		int temp = data[1];
		data[1] = data[4];
		data[4] = temp;
		
		//출력
		for(int i=0 ; i<data.length ; i++) {
			System.out.println(data[i]);
		}
	}

}
