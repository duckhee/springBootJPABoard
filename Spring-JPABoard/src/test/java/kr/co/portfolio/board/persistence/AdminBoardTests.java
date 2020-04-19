package kr.co.portfolio.board.persistence;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.portfolio.admin.persistence.BoardCustomCrudAdminRepository;
import kr.co.portfolio.domain.BoardVO;
import kr.co.portfolio.persistence.BoardCustomCrudRepository;
import kr.co.portfoliokr.page.PageMaker;
import kr.co.portfoliokr.page.PageVO;
import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminBoardTests {

	@Autowired
	private BoardCustomCrudAdminRepository repo;
	
	
	@Test
	public void MainTests() {
		log.info("Main Tests");
		log.info("Get Class :" + repo.getClass());
	}
	
	@Test
	public void InsertTests() {
		log.info("Insert Tests");
		for(int i = 0; i < 100; i++) {
			/** Insert VO */
			BoardVO board = new BoardVO();
			board.setTitle("test..." + i);
			board.setContent("Test Content ... " + i);
			board.setWriter("user@co.kr");
			repo.save(board);
		}
	}
	
	@Test
	public void PagingTests() {
		log.info("Paging Tests");
		/** Get Paging */
		Page<Object[]> getList = repo.getPaging(null,  null,  new PageVO().makePageable(0,  "idx"));
		/** Get Page Info */
		PageMaker<Object[]> paging = new PageMaker<>(getList);
		
		/** Get Result */
		paging.getResult().forEach(items->{
			log.info("get Result ");
			for(int i = 0; i < items.length; i++) {
				log.info("Get Value "+i+" : " + items[i]);
			}
		});
		
	}
	
	@Test
	public void ViewTests() {
		log.info("View Tests");
		BoardVO board = repo.findById(2L).get();
		log.info("get Board :" + board.toString());
		
	}
	
	@Test
	public void UpdateCntTests() {
		log.info("Update Cnt Tests");
		repo.viewCntup(1L);
		BoardVO board = repo.findById(1L).get();
		log.info("Board :" + board.toString());
	}
	
	@Test
	public void ModifyTests() {
		log.info("Modify Tests");
		BoardVO board = repo.findById(10L).get();
		board.setTitle("Test Modify");
		repo.save(board);
		board = repo.findById(10L).get();
		log.info("Modify : " + board);
	}
	
	@Test
	public void DeleteTests() {
		log.info("Delete Tests");
		repo.deleteById(101L);
		try {
			BoardVO board = repo.findById(101L).get();
			log.info("Delete Board Failed : " + board);
		}catch (Exception e) {
			// TODO: handle exception
			log.info("Board Delete Done ");
		}
		
	}
}
