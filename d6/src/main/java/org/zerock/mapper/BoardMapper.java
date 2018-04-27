package org.zerock.mapper;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper extends GenericMapper<BoardVO, Long>{

	public int getCount(Criteria cri);
	
}
