package kr.co.portfolio.admin.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.co.portfolio.domain.BoardVO;

public interface BoardCustomCrudAdminRepository extends CrudRepository<BoardVO, Long>, BoardCustomAdmin{
 
	/** View Board Update View cnt */
	@Modifying
	@Transactional
	@Query("UPDATE FROM BoardVO b SET b.cnt = b.cnt + 1 WHERE b.idx = ?1")
	public void viewCntup(Long bno);
}
