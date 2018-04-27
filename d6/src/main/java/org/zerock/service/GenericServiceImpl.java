package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.Criteria;
import org.zerock.mapper.GenericMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public abstract class GenericServiceImpl<T,K, M extends GenericMapper<T, K>> implements GenericService<T, K> {

	@Setter(onMethod_={@Autowired})
	@Getter
	private M mapper;
	

	@Override
	public void register(T vo) throws Exception {
		
		log.info("insert" + vo);
		mapper.insert(vo);
		
	}

	@Override
	public T get(K pk) throws Exception {

		log.info("get: "+ pk);
		return mapper.read(pk);
	}

	@Override
	public void modify(T vo) throws Exception {
		
		mapper.update(vo);
		
	}

	@Override
	public void remove(K pk) throws Exception {

		mapper.delete(pk);
		
	}

	@Override
	public List<T> getList(Criteria cri) throws Exception {
		
		return mapper.list(cri);
	}
	
	
}
