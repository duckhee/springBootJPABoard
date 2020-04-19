package kr.co.portfolio.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.portfolio.domain.BoardVO;
import kr.co.portfoliokr.page.PageVO;

@Controller
@RequestMapping(value="/admin/boards/*")
public class AdminBoardController {
	
	@GetMapping(value= {"","/"})
	public String IndexPage() {
		return "redirect:/admin/boards/list";
	}
	
	@GetMapping(value="/create")
	public String CreatePage(@ModelAttribute("board")BoardVO board) {
		return "";
	}

	@PostMapping(value="/create")
	public String CreateDo(@ModelAttribute("board")BoardVO board, RedirectAttributes flash) {
		return "";
	}
	
	@GetMapping(value="/modify")
	public String ModifyPage(@RequestParam(name = "bno", required = false)Long bno, @ModelAttribute("board")BoardVO board, RedirectAttributes flash) {
		return "";
	}
	
	@PostMapping(value="/modify")
	public String ModifyDo(@ModelAttribute("board")BoardVO board, RedirectAttributes flash) {
		return "";
	}
	
	@GetMapping(value="/list")
	public String Paging(@ModelAttribute("pageVO")PageVO page, Model model) {
		return "";
	}
	
	@GetMapping(value="/view")
	public String ViewPage(@RequestParam(name="bno", required = false)Long bno, RedirectAttributes flash) {
		return "";
	}
	
	@PostMapping(value="/delete")
	public String DeleteDo() {
		return "";
	}
}
