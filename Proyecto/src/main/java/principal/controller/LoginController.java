package principal.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Usuario;
import principal.servicio.imp.UsuarioServiceImpl;



@RequestMapping("/login")
@Controller
public class LoginController {
	
	
	
	
	@GetMapping(value= {"","/"})
	String homelogin(Model model) {
		
	
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		
		
		return "login";
	}
	
	
}