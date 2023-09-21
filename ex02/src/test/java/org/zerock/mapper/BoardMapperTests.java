package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.EachTimeVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void TestGetList() {
		boardMapper.getList().forEach(x->log.info(x));		
	}
	
	@Test
	public void TestGetListWithPaging() {
		Criteria cri = new Criteria();
		cri.setType("C");
		cri.setKeyword("수정");				
		boardMapper.getListWithPaging(cri).forEach(x->log.info("결과확인:"+x));
		
	}
	
	@Test
	public void TestRead() {
		log.info("2번글 읽기:"+boardMapper.read(2L));
	}
	
	@Test
	public void TestInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("mapper테스트");
		vo.setContent("잘들어가자");
		vo.setWriter("테스터");
		boardMapper.insert(vo);
	}
	
	@Test
	public void TestUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(2L);
		vo.setTitle("업데이트2");
		vo.setContent("업데이트");
		boardMapper.update(vo);	
		log.info("업데이트 테스트2:"+boardMapper.update(vo));
	}
	
	@Test
	public void TestDelete() {
		log.info("삭제:"+boardMapper.delete(2L));
	}
	
	@Test
	public void TestInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("mapper테스트");
		vo.setContent("잘되겠지");
		vo.setWriter("테스터");
		boardMapper.insertSelectKey(vo);
		log.info("입력된 글번호는:"+vo.getBno());
	}
	
	@Test //더미데이터 넣기
	public void insertData() {
		BoardVO vo = new BoardVO();
		
		for(int i=0; i<5; i++) {
			vo.setTitle("mapper테스트"+i);
			vo.setContent("들어가자"+i);
			vo.setWriter("테스터"+i);
			boardMapper.insert(vo);
		}		
	}
	
	@Test
	public void TestRank() {
		boardMapper.rank().forEach(x->log.info(x));
	}
	
	@Test
	public void TestCount() {	
		Criteria cri = new Criteria();
		log.info("전체글갯수: "+boardMapper.count(cri));
	}
	
	@Test
	public void TestLastBoard() {
		log.info("최신글 5개:"+boardMapper.lastBoard());		
	}
	
	@Test
	public void TestEachTime() {
		EachTimeVO tvo = new EachTimeVO();
		log.info("시간대별 글갯수:"+boardMapper.eachTime());			
	}
	
	@Test
	public void testGood() {
		boardMapper.good(100L);
	}
	
	
	
	
	

}
