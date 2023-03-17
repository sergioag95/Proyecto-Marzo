package principal.controller;

import java.util.ArrayList; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Rol;
import principal.modelo.Usuario;
import principal.modelo.dto.UsuarioDTO;

import principal.servicio.imp.UsuarioServiceImpl;

@RequestMapping("/usuarios")
@Controller
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl userDetailsService;
	
	@GetMapping(value= {"","/"})
	String homeusuarios(Model model) {
		
		// Salir a buscar a la BBDD
		
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) userDetailsService.listarUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);
		model.addAttribute("usuarioaEditar", new Usuario());
		model.addAttribute("usuarioNuevo", new Usuario());
		
		
		//
		
		return "usuarios";
	}
	
	@PostMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Integer id, @ModelAttribute("usuarioaEditar") Usuario usuarioEditado, BindingResult bindingresult) {
		
		Usuario usuarioaeditar= userDetailsService.obtenerUsuarioPorID(id);
		
		usuarioaeditar.setNombre(usuarioEditado.getNombre());
		
		usuarioaeditar.setUsername(usuarioEditado.getUsername());
		
		usuarioaeditar.setPassword(usuarioEditado.getPassword());
		
		userDetailsService.insertarUsuario(usuarioaeditar);
		
		return "redirect:/usuarios";
	}
	
	@PostMapping("/add")
	public String addUsuario(@ModelAttribute("usuarioNuevo") Usuario usuarioNew, BindingResult bindingresult) {
		
		userDetailsService.insertarUsuario(usuarioNew);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping({"/{id}"})
	String idUsuario(Model model, @PathVariable Integer id) {
		
		Usuario usuarioMostrar = userDetailsService.obtenerUsuarioPorID(id);
		model.addAttribute("usuarioMostrar",usuarioMostrar);
		
		return "usuario";
	}
	
	@GetMapping("/delete/{id}")
	String deleteUsuario(Model model, @PathVariable Integer id) {
		
		if (elUsuarioLogueadoesAdmin()) {
			
			Usuario aeliminar = userDetailsService.obtenerUsuarioPorID(id);
			userDetailsService.eliminarUsuario(aeliminar);
			
		}
		
		return "redirect:/";
	}
	
	private boolean elUsuarioLogueadoesAdmin() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		
		if (principal instanceof UserDetails) {
			
			userDetails = (UserDetails) principal;
			
			Usuario u = userDetailsService.obtenerUsuarioPorNombre(userDetails.getUsername());
			
			for(Rol r: u.getRoles()) {
				
				if (r.getNombre().compareTo("ROLE_ADMIN") == 0) {
					
					return true;
					
				}
			}
		}
		
		return false;
	}
	
	@GetMapping("/registro")
	public String mostrarRegistro(Model model, @ModelAttribute("usuarioNuevo") Usuario usuarioNew, BindingResult bindingresult) {
		
		model.addAttribute("newUserDTO", new UsuarioDTO());
		
		return "registro";
	}
	
	@PostMapping("/addRegistro")
	public String addRegistro(@ModelAttribute("usuarioNuevo") UsuarioDTO usuarioNew, BindingResult bindingresult) {
		
		userDetailsService.insertarusuarioDTO(usuarioNew);
		
		return "login";
	}
	 
}