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
public class Test10MemberBoard {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//1. 회원별 게시물을 조회
		List<MemberBoardVO> list = sqlSession.selectList("memberBoard.complex3");
		
		//2. 결과 출력
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