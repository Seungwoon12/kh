package sort;

public class Test03 {
	public static void main(String[] args) {
		
		//언제든지 바뀔 수 있는 데이터 준비
				int[] data = new int[] { 30, 50, 20, 10, 40 };
				
				//한 번만 정렬
				// 1. 처음(0)부터 끝(4)까지 범위에서 최소값 위치를 찾아낸다
				// 2. 1번에서 찾은 위치와 처음(0)을 교체한다
				
				int minIndex = 0;	
				for(int i=1; i<data.length; i++) {
					if(data[minIndex] > data[i]) {
						minIndex = i;
					}
				}
				System.out.println("minIndex = "+minIndex);
				
				//data[minIndex]와 data[0]을 교체
				int temp = data[minIndex];
				data[minIndex] = data[0];
				data[0] = temp;
				
				//출력
				for(int i=0; i < data.length; i++) {
					System.out.println(data[i]);
				}
			}
		}
