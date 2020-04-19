package kr.co.portfolio.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardCustom {
	/** */
	/** Custom Board Paging */
	public Page<Object[]> getPaging(String type, String keyword, Pageable page);
	/** */
}
