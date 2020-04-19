package kr.co.portfolio.admin.persistence;

import org.springframework.data.repository.CrudRepository;

import kr.co.portfolio.domain.BoardVO;

public interface BoardCustomCrudAdminRepository extends CrudRepository<BoardVO, Long>, BoardCustomAdmin{
 
}
