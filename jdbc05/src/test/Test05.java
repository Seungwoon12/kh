package test;

import java.util.Scanner;
import java.util.regex.Pattern;

import beans.WorkerDao;
import beans.WorkerDto;

public class Test05 {
	public static void main(String[] args) throws Exception {
		//worker테이블에 데이터 등록
		// - WorkerDao, WorkerDto를 만들어서 진행

		//데이터 준비
		Scanner sc = new Scanner(System.in);
		WorkerDto dto = new WorkerDto();
		System.out.print("이름 : ");
		dto.setWorker_name(sc.next());
		System.out.print("고용일 : ");
		dto.setHire_date(sc.next());
		System.out.print("급여(원) : ");
		dto.setSalary(sc.nextInt());
		System.out.print("직급 : ");
		dto.setPosition(sc.next());
		sc.close();
		
// 정규 표현식
//		boolean isDate = Pattern.matches("(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", dto.getHire_date());
//		if(!isDate) {
//			System.out.println("잘못된 날짜 형식");
//			System.exit(-1);//비정상 종료
//		}
		
		//데이터 등록
		WorkerDao dao = new WorkerDao();
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
