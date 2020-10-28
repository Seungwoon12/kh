package api.collection4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test05 {
	public static void main(String[] args) {
		//저장소
		Map<String, String> db = new HashMap<>();
		
		//데이터 추가
		db.put("admin", "admin1234");
		db.put("master", "master1234");
		db.put("test", "test1234");
		db.put("user", "user1234");
		
		Set<String> set = db.keySet();
		System.out.println(set);
		
		for(String id : set) {
			System.out.println("id = "+id);
			System.out.println("pw = "+db.get(id));
		}
	}
}
