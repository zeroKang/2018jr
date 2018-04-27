package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;

public interface GenericService <T, K>{
	
	public void register(T vo)throws Exception;
	
	public T get(K pk)throws Exception;
	
	public void modify(T vo)throws Exception;
	
	public void remove(K pk)throws Exception;
	
	public List<T> getList(Criteria cri)throws Exception;

}
