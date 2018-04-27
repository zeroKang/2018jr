package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.search.SearchMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SearchMapperTests {

	@Autowired
	private SearchMapper mapper;
	
	@Test
	public void test1() {
		
		log.info(mapper.search1("c", "�׽�Ʈ"));
	}
	
	@Test
	public void test2() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("t", "�׽�Ʈ");
		map.put("c", "�׽�Ʈ");
		map.put("w", "�׽�Ʈ");
		

		
		log.info(mapper.search2(map));
	}
	
	
	@Test
	public void testNow() {
		
		log.info(mapper.getTime());
	}
	
	
}
