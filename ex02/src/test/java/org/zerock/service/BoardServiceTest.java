package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void TestGetList() {
		log.info("리스트서비스: "+service.getList(new Criteria(2,4)));
	}
	
	@Test
	public void TestRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Service 테스트");
		vo.setContent("서비스 내용입력");
		vo.setWriter("서비스사용자");
		service.register(vo);		
	}
	
	@Test
	public void TestModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(33L);
		vo.setTitle("Service 수정");
		vo.setContent("내용수정");		
		log.info("수정 서비스: "+service.modify(vo));
		
	}
	
	@Test
	public void TestRemove() {		
		log.info("삭제 서비스: "+service.remove(31L)); 
	}
	
	@Test
	public void TestGet() {
		log.info("상세보기 서비스:"+service.get(3L));
	}
	
	@Test
	public void TestGood() {
		log.info("좋아요+1");
		
	}
	
	@Test
	public void testNow() {
		log.info("현재시간:"+service.now());
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
