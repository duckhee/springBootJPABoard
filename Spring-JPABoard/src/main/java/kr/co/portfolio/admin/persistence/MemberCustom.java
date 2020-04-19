package kr.co.portfolio.admin.persistence;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberCustom {
	/** Custom Paging */
	public Page<Object[]> getPaging(String type, String keyword, Pageable page);
	
}
