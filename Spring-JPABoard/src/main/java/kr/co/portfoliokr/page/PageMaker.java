package kr.co.portfoliokr.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "pageList")
public class PageMaker<T> {

	private Page<T> result;
	/** Prev Page */
	private Pageable prevPage;
	/** Next Page*/
	private Pageable nextPage;
	/** */
	private int currentPageNum;
	/** Total Page */
	private int totalPage;
	/** Current page */
	private Pageable currentPage;
	
	private List<Pageable> pageList;
	
	public PageMaker(Page<T> result) {
		this.result = result;
		this.currentPage = result.getPageable();
		this.currentPageNum = currentPage.getPageNumber() + 1;
		this.totalPage = result.getTotalPages();
		this.pageList = new ArrayList<>();
		
		calcPage();
	}
	
	private void calcPage() {
		/** Temperature End Page */
		int tempEndNum = (int)(Math.ceil(this.currentPageNum/10.0) * 10);
		/** Start Page */
		int startNum = tempEndNum - 9;
		/** */
		Pageable startPage = this.currentPage;
		/** */
		for(int i = 0; i < this.currentPageNum; i++) {
			startPage = startPage.previousOrFirst();
		}
		/** */
		this.prevPage = startPage.getPageNumber() <= 0 ? null : startPage.previousOrFirst();
		/** */
		if(this.totalPage < tempEndNum) {
			tempEndNum = this.totalPage;
			this.nextPage = null;
		}
		/** */
		for(int i = startNum; i <= tempEndNum; i++) {
			pageList.add(startPage);
			startPage = startPage.next();
		}
		/** */
		this.nextPage = startPage.getPageNumber() + 1 < totalPage ? startPage : null;
	}
	
}
