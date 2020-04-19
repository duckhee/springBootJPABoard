package kr.co.portfolio.admin.persistence;

import org.springframework.data.repository.CrudRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import kr.co.portfolio.domain.QUserVO;
import kr.co.portfolio.domain.UserVO;

public interface MemberCustomCrudRepository extends CrudRepository<UserVO, Long>, MemberCustom{

	/** Boolean Check Value */
	public default Predicate makePredicate(String type, String keyword) {
		/** Boolean Builder */
		BooleanBuilder builder = new BooleanBuilder();
		QUserVO member = QUserVO.userVO;
		builder.and(member.idx.gt(0));
		
		/** Not Input Type Value */
		if(type == null) {
			return builder;
		}
		/** Search Options */
		switch(type) {
		case "e":
			builder.and(member.email.like("%" + keyword + "%"));
			break;
		case "n":
			builder.and(member.name.like("%" + keyword + "%"));
			break;
		}
		
		return builder;
	}
}
