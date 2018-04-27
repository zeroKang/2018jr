package org.zerock.root;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardMapperTests {

	@Setter(onMethod_={@Autowired})	
	private BoardMapper mapper;
	
	@Test
	public void test3List() {
		
		mapper.list(new Criteria(2)).forEach(vo -> log.info(vo));
		
	}
	
	@Test
	public void test4Update() {
		
		BoardVO vo = mapper.read(100L);
		
		log.info(vo);
		
		vo.setTitle("update 제목");
		vo.setContent("update 내용");
		
		mapper.update(vo);
		
		log.info(mapper.read(100L));
		
	}
	
	@Test
	public void test5Delete() {
		
		
		log.info("DELETE COUNT: "+mapper.delete(1L));
		
	}
	
	
	@Test
	public void test2Read() {
		
		log.info(mapper.read(50L));
		
	}
	
	@Test
	public void test1Insert() {
		
		for(int i = 0; i < 10; i++) {
			
			BoardVO vo = new BoardVO();
			vo.setTitle("제목 ...." + i);
			vo.setContent("내용은....."+i);
			vo.setWriter("user0"+ i%10);
			
			log.info("insert result: "+ mapper.insert(vo));
		}
		
	}
}
