package kr.co.portfolio.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.portfolio.admin.persistence.MemberCustomCrudRepository;
import kr.co.portfolio.domain.UserVO;
import kr.co.portfoliokr.page.PageMaker;
import kr.co.portfoliokr.page.PageVO;

@Controller
@RequestMapping(value="/admin/members/*")
public class AdminMemberController {
	
	
	@Autowired
	private MemberCustomCrudRepository repo;
	
	@GetMapping(value= {"","/"})
	public String IndexPage() {
		return "redirect:/admin/members/list";
	}
	
	@GetMapping(value="/registe")
	public String RegistePage(@ModelAttribute("user")UserVO user) {
		return "";
	}
	
	@PostMapping(value="/registe")
	public String RegisteDo(@ModelAttribute("user")UserVO user, RedirectAttributes flash) {
		return "";
	}
	
	@GetMapping(value="/modify")
	public String ModifyPage(@ModelAttribute("user")UserVO user, @RequestParam(name = "userIdx", required = false)Long idx, RedirectAttributes flash) {
		return "";
	}
	
	@PostMapping(value="/modify")
	public String ModiifyDo() {
		return "";
	}
	
	@GetMapping(value="/view")
	public String ViewPage() {
		return "";
	}
	
	@GetMapping(value="/list")
	public String Paging(@ModelAttribute("pageVO")PageVO page, Model model) {
		/** Make Paging Maker */
		Pageable pages = page.makePageable(0,  "idx");
		/** Get Page Info */
		Page<Object[]> getList = repo.getPaging(page.getType(), page.getKeyword(), pages);
		/** Model Setting */
		model.addAttribute("list", new PageMaker<>(getList));
		return "";
	}
	
	@PostMapping(value="/delete")
	public String DeleteDo() {
		return "";
	}

}
