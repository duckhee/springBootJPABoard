package kr.co.portfolio.admin.persistence;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

import kr.co.portfolio.domain.QUserRoleVO;
import kr.co.portfolio.domain.QUserVO;
import kr.co.portfolio.domain.UserVO;

public class MemberCustomCrudRepositoryImpl extends QuerydslRepositorySupport implements MemberCustom{

	public MemberCustomCrudRepositoryImpl() {
		super(UserVO.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Page<Object[]> getPaging(String type, String keyword, Pageable page) {
		// TODO Auto-generated method stub
		
		QUserVO user = QUserVO.userVO;
		QUserRoleVO userRole = QUserRoleVO.userRoleVO;
		
		/** Select Table Set */
		JPQLQuery<UserVO> query = from(user);
		/** Select Query */
		JPQLQuery<Tuple> tuple = query.select(user.idx, user.email, user.name, user.createdAt, user.updatedAt);
		if(type != null) {
			switch(type.toLowerCase()) {
			case "n":
				tuple.where(user.name.like("%" + keyword + "%"));
				break;
			case "e":
				tuple.where(user.email.like("%" + keyword + "%"));
				break;
			}
		}
		/** */
		tuple.groupBy(user.idx);
		/** */
		tuple.orderBy(user.idx.desc());
		/** */
		tuple.offset(page.getOffset());
		/** */
		tuple.limit(page.getPageSize());
		/** */
		List<Tuple> list = tuple.fetch();
		/** */
		List<Object[]> resultList = new ArrayList<>();
		list.forEach(roles->{
			resultList.add(roles.toArray());
		});
		
		/** */
		long total = tuple.fetchCount();
		
		return new PageImpl<>(resultList, page, total);
	}

}
