package kr.co.portfolio.board.persistence;



import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.portfolio.admin.persistence.MemberCustomCrudRepository;
import kr.co.portfolio.domain.UserRoleVO;
import kr.co.portfolio.domain.UserVO;
import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

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
	public void InsertTest() {
		log.info("Insert Tests");
		UserVO user = new UserVO();
		user.setEmail("admin@co.kr");
		user.setName("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		
		/** RoleVO Set */
		UserRoleVO role = new UserRoleVO();
		role.setRole("ADMIN");
		user.setRoles(Arrays.asList(role));
		repo.save(user);
		log.info("User Insert Done");
	}
	
	@Test
	public void InsertManyTests() {
		log.info("Insert Many Tests");
		for(int i = 0; i < 100; i++) {
			UserVO user = new UserVO();
			user.setEmail("test" + i + "@co.kr");
			user.setName("tester" + i);
			user.setPassword(passwordEncoder.encode("test" + i));
			UserRoleVO role = new UserRoleVO();
			if(i <= 80) {
				role.setRole("BASIC");
			}else if(i<=90){
				role.setRole("MANAGER");
			}else {
				role.setRole("ADMIN");
			}
			/**  Role setting */
			user.setRoles(Arrays.asList(role));
			repo.save(user);
		}
		log.info("User Insert 100 Done");
	}
	
	@Test
	public void PagingTests() {
		log.info("Paging User Tests");
	}
}
