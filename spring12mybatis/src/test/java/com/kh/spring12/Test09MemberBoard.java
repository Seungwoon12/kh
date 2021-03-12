package com.kh.spring12;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.BoardDto;
import com.kh.spring12.entity.MemberBoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
//목표 : member-board-mapper.xml를 이용하여 "회원별로 작성한 게시물 목록"을 조회하고 싶다!
public class Test09MemberBoard {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//1. 회원 조회
		List<MemberBoardVO> list = sqlSession.selectList("memberBoard.complex1");
		
		//2. 회원별 게시물을 조회하여 각각의 항목에 추가
		//= 조회 수는 list.size() 만큼이다.
		for(MemberBoardVO vo : list) {
			List<BoardDto> boardList = sqlSession.selectList("memberBoard.complex2", vo.getMember_id());
			vo.setBoardList(boardList);
		}
		
		//3. 결과 출력
		for(MemberBoardVO vo : list) {
			//회원정보
			System.out.println("ID : " + vo.getMember_id());
			
			//글정보
			for(BoardDto boardDto : vo.getBoardList()) {
				System.out.println("→ " + boardDto.getBoard_title());
			}
		}
	}
	
}