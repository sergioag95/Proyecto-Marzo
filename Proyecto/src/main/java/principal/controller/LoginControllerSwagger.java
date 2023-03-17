package principal.controller;



import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/loginSwagger")
@RestController
public class LoginControllerSwagger {
	
	@GetMapping(value= {"","/"})
	String homelogin(Model model) {
		
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		
		
		return "login";
	}
}