package sort;
//import java.lang.*;
public class Test05 {
	public static void main(String[] args) {
		//데이터 준비
		int[] data = new int[] {20, 50, 30, 10, 40};
		
		//삽입정렬 - 1회차(아무위치나 지정)
		// - 파악해야 할 항목 : 현재위치, 삽입위치
		
		int k=2;//현재위치
		int m=k;//이동해야 할 위치
		int backup = data[k];
		for(int i=k-1; i>=0; i--) {//k-1부터 0까지 반복
			System.out.println("backup = " + backup + ", data[i] = "+data[i]);
			if(backup < data[i]) {//배열이 백업보다 클 때
				//m을 왼쪽으로 한칸 이동시킨다
				m--;
				//data[i]를 오른쪽으로 한칸 이동시킨다
				data[i+1] = data[i];
			}
		}
		System.out.println("현재위치 : "+k+" , 들어갈 위치 : "+m);
		//신나게 계산한 m 위치에 백업 데이터를 삽입
		data[m] = backup;
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}