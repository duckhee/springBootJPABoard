package kr.co.portfolio.persistence;

import org.springframework.data.repository.CrudRepository;

import kr.co.portfolio.domain.BoardVO;

public interface BoardCustomCrudRepository extends CrudRepository<BoardVO, Long>, BoardCustom{

}
