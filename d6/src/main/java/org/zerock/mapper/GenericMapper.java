package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;

public interface GenericMapper<V, K> {

	public int insert(V vo);
	
	public V read(K key);
	
	public List<V> list(Criteria cri);
	
	public int update(V vo);
	
	public int delete(K key);
}
