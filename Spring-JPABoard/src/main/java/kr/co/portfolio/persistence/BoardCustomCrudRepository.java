package kr.co.portfolio.persistence;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.co.portfolio.domain.BoardVO;

public interface BoardCustomCrudRepository extends CrudRepository<BoardVO, Long>, BoardCustom{

	/** View Board Update View cnt */
	@Modifying
	@Transactional
	@Query("UPDATE FROM BoardVO b SET b.cnt = b.cnt + 1 WHERE b.idx = ?1")
	public int viewCntup(Long bno);
}
