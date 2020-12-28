package test;

import beans.WorkerDao;
import beans.WorkerDto;

public class Test08 {
	public static void main(String[] args) throws Exception {
		//Worker 테이블의 데이터를 수정하기 위한 코드(DAO/DTO 사용)
		
		//데이터 준비(DTO)
		WorkerDto dto = new WorkerDto();
		dto.setWorker_no(1);
		dto.setWorker_name("둘리");
		dto.setHire_date("2020-03-03");
		dto.setSalary(2500000);
		dto.setPosition("사원");
		
		//데이터 수정처리(DAO)
		WorkerDao dao = new WorkerDao();
		boolean result = dao.update(dto);
		
		//결과에 따른 출력
		if(result) {
			System.out.println("수정 완료");
		}
		else {
			System.out.println("해당 번호의 직원은 존재하지 않습니다");
		}
	}
}