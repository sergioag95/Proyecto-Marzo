package principal.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Equipo;
import principal.persistencia.EquipoDAO;

@RequestMapping("/equipos")
@Controller
public class EquipoController{
	
	
	EquipoDAO equipoDAO = new EquipoDAO();
	
	
	
	@GetMapping(value= {"","/"})
	String homeequipos(Model model) {
		
		
		
		//Salir a buscar a la BBDD
		
		ArrayList<Equipo> misEquipos = equipoDAO.listarEquiposJPA();
		model.addAttribute("listaEquipos", misEquipos);
		model.addAttribute("equipoaEditar", new Equipo());
		model.addAttribute("equipoNuevo", new Equipo());
		
		return "equipos";
	}
	
	
	@PostMapping("/edit/{id}")
	public String editarEquipo(@PathVariable Integer id, @ModelAttribute("equipoaEditar") Equipo EquipoEditado, BindingResult bidingresult) {
		
		Equipo equipoaEditar = equipoDAO.bucarPorIdJPA(id);
		
		equipoaEditar.setNombre(EquipoEditado.getNombre());
		
		equipoaEditar.setCiudad(EquipoEditado.getCiudad());

		
		equipoDAO.modificarEquipoJPA(equipoaEditar);
		
		
		return "redirect:/equipos";
	}
	
	@PostMapping("/add")
	public String addEquipo(@ModelAttribute("equipoNuevo") Equipo EquipoNew, BindingResult bidingresult) {
		
		equipoDAO.modificarEquipoJPA(EquipoNew);
		
		return "redirect:/equipos";
	}
	
	
	@GetMapping(value= {"/{id}"})
	String idEquipo(Model model, @PathVariable Integer id) {
		
		//model.addAttribute("EquipoAMostrar", equipoDAO.bucarPorIdJPA(id));
		Equipo equipoaMostrar = equipoDAO.bucarPorIdJPA(id);
		model.addAttribute("equipoaMostrar", equipoaMostrar);
		
		return "equipo";
	}
	
	@GetMapping(value= {"/delete/{id}"})
	String deleteEquipo(Model model, @PathVariable Integer id) {
		
		Equipo aeliminar = equipoDAO.bucarPorIdJPA(id);
		equipoDAO.eliminarEquipoJPA(aeliminar);
		return "redirect:/equipos";
		
	}
}