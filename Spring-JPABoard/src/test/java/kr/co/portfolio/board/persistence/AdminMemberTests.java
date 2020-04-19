package kr.co.portfolio.board.persistence;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.portfolio.admin.persistence.MemberCustomCrudRepository;
import kr.co.portfolio.domain.UserRoleVO;
import kr.co.portfolio.domain.UserVO;
import kr.co.portfoliokr.page.PageMaker;
import kr.co.portfoliokr.page.PageVO;
import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMemberTests {

	@Autowired
	private MemberCustomCrudRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	
	@Test
	public void MainTests() {
		log.info("Main Tests");
		log.info("Get Class : " + repo.getClass());
	}
	
	@Test
	public void InsertMembersTests() {
		log.info("Insert Tests");
		UserVO user = new UserVO();
		UserRoleVO role = new UserRoleVO();
		user.setEmail("user@co.kr");
		user.setPassword(passwordEncoder.encode("user"));
		user.setName("user");
		role.setRole("BASIC");
		user.setRoles(Arrays.asList(role));
		repo.save(user);
	}
	
	@Test
	public void PagingMemberTests() {
		log.info("Paging User Tests");
		PageVO pageObject = new PageVO();
		Pageable page =  pageObject.makePageable(0, "idx");
		Page<Object[]> list = repo.getPaging(null, null,  page);
		 
		PageMaker<Object[]> getPaging = new PageMaker<>(list);
		
		getPaging.getResult().getContent().forEach(items->{
			log.info("result ");
			for(int i = 0; i< items.length; i++) {
				log.info("get Result "+i+": " + items[i]);
			}
		});
			
		
		
	}
}
