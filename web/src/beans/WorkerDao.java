package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkerDao {
	//등록
	public void insert(WorkerDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "insert into worker values(worker_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getWorker_name());
		ps.setString(2, dto.getHire_date());
		ps.setInt(3, dto.getSalary());
		ps.setString(4, dto.getPosition());
		
		ps.execute();
		
		con.close();
	}
	//조회
	public List<WorkerDto> select() throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "select * from worker order by worker_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<WorkerDto> list = new ArrayList<>();
		while(rs.next()) {
			WorkerDto dto = new WorkerDto();
			dto.setWorker_no(rs.getInt("worker_no"));
			dto.setWorker_name(rs.getString("worker_name"));
			dto.setHire_date(rs.getString("hire_date"));
			dto.setSalary(rs.getInt("salary"));
			dto.setPosition(rs.getString("position"));
			
			list.add(dto);
		}
		con.close();
		
		return list;
	}
}