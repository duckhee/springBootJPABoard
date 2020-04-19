package kr.co.portfolio.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/boards/*")
public class AdminBoardController {
	
	@GetMapping(value= {"","/"})
	public String IndexPage() {
		return "redirect:/admin/boards/list";
	}
	
	@GetMapping(value="/create")
	public String CreatePage() {
		return "";
	}

	@PostMapping(value="/create")
	public String CreateDo() {
		return "";
	}
	
	@GetMapping(value="/modify")
	public String ModifyPage() {
		return "";
	}
	
	@PostMapping(value="/modify")
	public String ModifyDo() {
		return "";
	}
	
	@GetMapping(value="/list")
	public String Paging() {
		return "";
	}
	
	@GetMapping(value="/view")
	public String ViewPage() {
		return "";
	}
	
	@PostMapping(value="/delete")
	public String DeleteDo() {
		return "";
	}
}
