package test;

import java.util.List;

import beans.WorkerDao;
import beans.WorkerDto;

public class Test14 {
	public static void main(String[] args) {
		//WorkerDao를 이용한 테이블 조회
		try {
			WorkerDao dao = new WorkerDao();
			List<WorkerDto> list = dao.select();
			
			for(WorkerDto dto : list) {
				//출력
				System.out.println(dto.getWorker_name());
				System.out.println(dto.getSalary());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}