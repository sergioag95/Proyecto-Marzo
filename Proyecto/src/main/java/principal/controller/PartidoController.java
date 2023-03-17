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
import principal.modelo.Partido;
import principal.persistencia.EquipoDAO;
import principal.persistencia.PartidoDAO;

@RequestMapping("/partidos")
@Controller
public class PartidoController{
	
	
	PartidoDAO partidoDAO = new PartidoDAO();
	EquipoDAO equipoDAO = new EquipoDAO();
	
	
	
	@GetMapping(value= {"","/"})
	String homepartidos(Model model) {
		
		
		
		//Salir a buscar a la BBDD
		
		ArrayList<Partido> misPartidos = partidoDAO.listarPartidosJPA();
		ArrayList<Equipo> misEquipos = equipoDAO.listarEquiposJPA();
		model.addAttribute("listaPartidos", misPartidos);
		model.addAttribute("listaEquipos", misEquipos);
		model.addAttribute("partidoaEditar", new Partido());
		model.addAttribute("partidoNuevo", new Partido());
		
		return "partidos";
	}
	
	
	@PostMapping("/edit/{id}")
	public String editarPartido(@PathVariable Integer id, @ModelAttribute("partidoaEditar") Partido PartidoEditado, BindingResult bidingresult) {
		
		Partido partidoaEditar = partidoDAO.bucarPorIdJPA(id);
		
		partidoaEditar.setLocal(PartidoEditado.getLocal());
		partidoaEditar.setLocal_res(PartidoEditado.getLocal_res());

		partidoaEditar.setVisitante(PartidoEditado.getVisitante());
		partidoaEditar.setVisitante_res(PartidoEditado.getVisitante_res());

		
		partidoDAO.modificarPartidoJPA(partidoaEditar);
		
		
		return "redirect:/partidos";
	}
	
	@PostMapping("/add")
	public String addPartido(@ModelAttribute("partidoNuevo") Partido PartidoNew, BindingResult bidingresult) {
		
		partidoDAO.modificarPartidoJPA(PartidoNew);
		
		return "redirect:/partidos";
	}
	
	
	@GetMapping(value= {"/{id}"})
	String idPartido(Model model, @PathVariable Integer id) {
		
		//model.addAttribute("PartidoAMostrar", partidoDAO.bucarPorIdJPA(id));
		Partido partidoaMostrar = partidoDAO.bucarPorIdJPA(id);
		model.addAttribute("partidoaMostrar", partidoaMostrar);
		
		return "partido";
	}
	
	@GetMapping(value= {"/delete/{id}"})
	String deletePartido(Model model, @PathVariable Integer id) {
		
		Partido aeliminar = partidoDAO.bucarPorIdJPA(id);
		partidoDAO.eliminarPartidoJPA(aeliminar);
		return "redirect:/partidos";
		
	}
}