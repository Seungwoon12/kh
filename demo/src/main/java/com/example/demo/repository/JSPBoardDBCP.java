package com.example.demo.repository;

import java.sql.*;
import java.util.*;
import javax.sql.*;

import com.example.demo.entity.JSPBoard;

import javax.naming.*;

public class JSPBoardDBCP {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private DataSource ds = null;

	public JSPBoardDBCP() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracleDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Vector<JSPBoard> getBoardList() {
		connect();
		Vector<JSPBoard> list = new Vector<JSPBoard>();

		String SQL = "select no, name, passwd, title, email, regdate, content from board";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				JSPBoard brd = new JSPBoard();
				brd.setNo(rs.getInt("no"));
				brd.setName(rs.getString("name"));
				brd.setPasswd(rs.getString("passwd"));
				brd.setTitle(rs.getString("title"));
				brd.setEmail(rs.getString("email"));
				brd.setRegdate(rs.getTimestamp("regdate"));
				brd.setContent(rs.getString("content"));

				list.add(brd);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public JSPBoard getBoard(int no) {
		connect();
		String SQL = "select no, name, passwd, title, email, regdate, content from board where no = ?";
		JSPBoard brd = new JSPBoard();

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			brd.setNo(rs.getInt("no"));
			brd.setName(rs.getString("name"));
			brd.setPasswd(rs.getString("passwd"));
			brd.setTitle(rs.getString("title"));
			brd.setEmail(rs.getString("email"));
			brd.setRegdate(rs.getTimestamp("regdate"));
			brd.setContent(rs.getString("content"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
	}

	public boolean insertDB(JSPBoard board) {
		boolean success = false;
		connect();
		String sql = "insert into board(no, name, passwd, title, email, content) values(board_seq.nextval, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPasswd());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disconnect();
		}
		return success;
	}

	public boolean updateDB(JSPBoard board) {
		boolean success = false;
		connect();
		String sql = "update board set name=?, title=?, email=?, content=? where no=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNo());

			int rowUdt = pstmt.executeUpdate();

			if (rowUdt == 1)
				success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disconnect();
		}
		return success;
	}

	public boolean deleteDB(int no) {
		boolean success = false;
		connect();
		String sql = "delete from board where no=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disconnect();
		}
		return success;
	}

	public boolean isPasswd(int no, String passwd) {
		boolean success = false;
		connect();
		String sql = "select passwd from board where no=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String orgPasswd = rs.getString(1);
			if (passwd.equals(orgPasswd))
				success = true;
			System.out.println(success);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disconnect();
		}
		return success;
	}
}