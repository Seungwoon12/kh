package api.collection4;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) {
		// List : 전체 처리도 가능하고 개별적인 처리도 가능한 위치(순서)가 있는 저장소
		// Set : 빠르게 일괄적으로 중복없이 접근하여 처리
		// Map : 개별접근을 빠르게 처리하는 저장소(라벨링)
		
		
		//Map<K,V>
		//- 두 개의 데이터를 세트로 저장하는 저장소
		//- K : key, 이름 역할을 수행하며 중복이 불가능하다(set)
		//- V : value, 값의 역할을 수행하며 중복이 가능하다
		//- 순서는 유지되나? 무시되나? : 무시된다!
		
		//저장소 생성
		Map<String, Integer> map = new HashMap<>();
		
		//데이터 추가 : add()가 아니라 put()
		map.put("a", 10);//a=10이라는 데이터 세트를 추가
		map.put("b", 10);//b=10이라는 데이터 세트를 추가
		map.put("c", 10);//c=10이라는 데이터 세트를 추가
		map.put("a", 20);//a=20이라는 데이터 세트를 추가(중복된 이름)
		
		//데이터 개수 및 확인 : size()로 동일
		System.out.println(map.size());
		System.out.println(map);
		
		//데이터 검색 : contains()로는 어려워서 key, value를 찾는 명령으로 분할
		System.out.println(map.containsKey("a"));//key 중에 a가 있냐?
		System.out.println(map.containsValue(20));//value 중에 20이 있냐?
		
		//데이터 삭제 : key로 지우던가 아니면 key+value으로 삭제(구분이 되도록 하기 위함)
		map.remove("b");
		System.out.println(map);
		
		//데이터 추출 : key로 value를 불러오는것만 가능하다
		//주의사항 
		// - value를 int 형태로 사용하면 위험하다
		// - 만약에 null이 나올 가능성이 있다면 int 대신 Integer를 사용해야 한다 
		Integer value = map.get("z");
		System.out.println(value);
	}
}