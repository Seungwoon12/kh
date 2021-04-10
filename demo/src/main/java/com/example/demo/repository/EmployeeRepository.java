package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeRepository {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String INSERT_EMP = "insert into s_emp(id, name, start_date, "
			+ "title, dept_name, salary) values "
			+ "(init_seq.nextval, ?, ?, ?, ?, ?)";
	
	private String LIST_EMP = "select id, name, start_date, title, "
			+ "dept_name, salary from s_emp order by name";
	
	public Connection getConnection () {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "web", "web");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			// Short Circuit
			// 비트 연산자 AND 의 특성 ===> 관계 연산자 AND 의 특성
			if (!conn.isClosed() && conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public void close(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			// Short Circuit
			// 비트 연산자 AND 의 특성 ===> 관계 연산자 AND 의 특성
			if (!conn.isClosed() && conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public void insertEmployee(Employee entity) {
		System.out.println("JDBC 기반 등록");
		
		try {
			conn = getConnection();
			
			System.out.println("연결 성공!");
			
			stmt = conn.prepareStatement(INSERT_EMP);
			
			stmt.setString(1,  entity.getName());
			stmt.setTimestamp(2, entity.getStartDate());
			stmt.setString(3, entity.getTitle());
			stmt.setString(4, entity.getDeptName());
			stmt.setDouble(5, entity.getSalary());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt, conn);
		}
	}
	
	public List<Employee> getEmployeeList () {
		System.out.println("JDBC 기반 리스팅");
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			conn = getConnection ();
			stmt = conn.prepareStatement(LIST_EMP);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getLong("id"));
				emp.setName(rs.getString("name"));
				emp.setStartDate(rs.getTimestamp("start_date"));
				emp.setTitle(rs.getString("title"));
				emp.setDeptName(rs.getString("dept_name"));
				emp.setSalary(rs.getDouble("salary"));
				
				employeeList.add(emp);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		
		return employeeList;
	}
}