package kr.co.portfolio.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/users/*")
public class AdminUserController {

	@GetMapping(value= {"","/"})
	public String Index() {
		return "redirect:/admin/users/login";
	}
	
	@GetMapping(value="/login")
	public String LoginPage() {
		return "";
	}
	
	@PostMapping(value="/login")
	public String LoginDo() {
		return "";
	}
	
	@GetMapping(value="/signup")
	public String SignUpPage() {
		return "";
	}
	
	@PostMapping(value="/signup")
	public String SignUpDo() {
		return "";
	}
	
	@GetMapping(value="/profile")
	public String Profile() {
		return "";
	}
	
	@GetMapping(value = "/modify")
	public String ModifyPage() {
		return "";
	}
	
	@PostMapping(value="/modify")
	public String ModifyDo() {
		return "";
	}
	
	@PostMapping(value="/delete")
	public String DeleteDo() {
		return "";
	}
	
	
}
