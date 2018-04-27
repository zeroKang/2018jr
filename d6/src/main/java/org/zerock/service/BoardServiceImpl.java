package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl extends GenericServiceImpl<BoardVO, Long, BoardMapper> implements BoardService {

	@Override
	public int getTotal(Criteria cri) {

		return getMapper().getCount(cri);
	}

}
