package kr.co.portfolio.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

import kr.co.portfolio.domain.BoardVO;
import kr.co.portfolio.domain.QBoardReplyVO;
import kr.co.portfolio.domain.QBoardVO;

public class BoardCustomCrudRepositoryImpl extends QuerydslRepositorySupport implements BoardCustom{

	public BoardCustomCrudRepositoryImpl() {
		// TODO Auto-generated constructor stub
		super(BoardVO.class);
	}

	@Override
	public Page<Object[]> getPaging(String type, String keyword, Pageable page) {
		// TODO Auto-generated method stub
		QBoardVO board = QBoardVO.boardVO;
		QBoardReplyVO reply = QBoardReplyVO.boardReplyVO;
		
		/** Query Make Search Table */
		JPQLQuery<BoardVO> query = from(board);
		/** Query Select Set */
		JPQLQuery<Tuple> tuple = query.select(board.idx, board.title, board.content, board.writer, reply.count(), board.createdAt, board.updatedAt);
		/** Left JOIN */
		tuple.leftJoin(reply);
		/** LEFT JOIN ON OPTION */
		tuple.on(board.idx.eq(reply.board.idx));
		tuple.where(board.idx.gt(0L));
		/** Search Option Type */
		if(type != null) {
			switch(type.toLowerCase()) {
			case "t":
				tuple.where(board.title.like("%" + keyword + "%"));
				break;
			case "w":
				tuple.where(board.writer.like("%" + keyword + "%"));
				break;
			case "c":
				tuple.where(board.content.like("%" + keyword + "%"));
				break;
			}
		}
		/** Group By */
		tuple.groupBy(board.idx);
		/** ORDER DESC */
		tuple.orderBy(board.idx.desc());
		/** Paging */
		tuple.offset(page.getOffset());
		tuple.limit(page.getPageSize());
		/** Get Fetch */
		List<Tuple> list = tuple.fetch();
		/** Return List */
		List<Object[]> resultList = new ArrayList<>();
		/** And Reply */
		list.forEach(t->{
			resultList.add(t.toArray());
		});
		/** Fetch Count */
		long total = tuple.fetchCount();
		
		return new PageImpl<>(resultList, page, total);
	}
	
	

}
