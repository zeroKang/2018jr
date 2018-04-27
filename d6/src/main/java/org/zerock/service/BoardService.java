package org.zerock.service;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService extends GenericService<BoardVO, Long>{

	int getTotal(Criteria cri);

}
