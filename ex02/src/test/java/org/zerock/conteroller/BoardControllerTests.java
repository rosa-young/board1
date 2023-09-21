package org.zerock.conteroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration //컨트롤러 테스트위해
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //컨트롤러
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx; //mockMvc 객체를 만들때 필요.
	
	private MockMvc mockMvc; //이 객체를 이용해서 컨트롤러 테스트를 해야함
							//객체를 직접 인스턴해서 사용해야함.
	
	@Before //junit으로 테스트할때 먼저 수행하는 메소드
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testlist() throws Exception  {
		log.info("url리스트 요청결과 모델데이터:" +
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception  {
		log.info("등록처리 요청결과:" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "junit으로")
				.param("content", "mockMVC를 이용해서")
				.param("writer", "test1"))
		.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGet() throws Exception  {
		log.info("url상세보기 모델데이터:" +
		mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "22"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRemove() throws Exception  {
		log.info("url삭제 모델데이터:" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "27"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception  {
		log.info("url수정 모델데이터:" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "30")
				.param("title", "modify test")
				.param("content", "수정내용")
				.param("writer", "test"))
		.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGetRemove() throws Exception  {
		log.info("url삭제화면 요청:" +
		mockMvc.perform(MockMvcRequestBuilders.get("/board/remove"))
		.andReturn().getModelAndView().getViewName());
	}
	
	
	
}
