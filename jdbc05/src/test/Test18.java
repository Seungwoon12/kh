package test;

import java.util.List;

import beans.WorkerDao;
import beans.WorkerDto;

public class Test18 {
	public static void main(String[] args) throws Exception {
		//worker 테이블에서 원하는 구간의 급여를 받는 사원을 조회
		//- select * from worker where salary between ? and ?
		//- select * from worker where salary >= ? and salary <= ?
		
		//데이터 준비(DTO로 처리가 불가능)
		int start = 1500000;
		int finish = 3500000;
		
		//데이터 구간검색(DB -> DAO)
		WorkerDao dao = new WorkerDao();
		List<WorkerDto> list = dao.search(start, finish);
		
		//출력(결과가 없을 수 있다)
		//if(list.size() == 0) {
		if(list.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		}
		else {
			for(WorkerDto dto : list) {
				System.out.print(dto.getWorker_name());
				System.out.print(" : ");
				System.out.println(dto.getSalary()+"원");
			}
		}
	}
}