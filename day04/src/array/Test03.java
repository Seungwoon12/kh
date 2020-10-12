
package array;

public class Test03 {
	public static void main(String[] args) {
//		배열을 만들면서 값도 설정
//		- 크기 숫자를 적을 수 없도록 되어 있다(자동계산)
		
//		10, 20, 30
		int[] a = new int[] {10, 20, 30};
//		int[] a = {10, 20, 30};//쓰지마세요!(C언어 문법)
//		a ---- [ 10 ][ 20 ][ 30 ]
		
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a.length);
	}
}