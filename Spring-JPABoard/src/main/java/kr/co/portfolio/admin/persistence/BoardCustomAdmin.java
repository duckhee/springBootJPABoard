package kr.co.portfolio.admin.persistence;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.co.portfolio.domain.BoardVO;

public interface BoardCustomAdmin {

	/** Board Paging Admin */
	public Page<Object[]> getPaging(String type, String keyword, Pageable page);
	/** View Board Update View cnt s*/
	public BoardVO viewCntup(Long bno);
}
