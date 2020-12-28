package test;

import beans.WorkerDao;

public class Test11 {
	public static void main(String[] args) throws Exception {
		//worker 테이블의 데이터를 삭제(퇴사)
		
		//데이터 준비
		int worker_no = 1;
		
		//삭제 처리
		WorkerDao dao = new WorkerDao();
		boolean result = dao.delete(worker_no);
		
		if(result) {
			System.out.println("퇴사 처리가 되었습니다");
		}
		else {
			System.out.println("해당 번호의 직원은 존재하지 않습니다");
		}
	}
}