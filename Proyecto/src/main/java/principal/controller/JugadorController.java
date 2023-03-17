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
import principal.modelo.Jugador;
import principal.persistencia.EquipoDAO;
import principal.persistencia.JugadorDAO;

@RequestMapping("/jugadores")
@Controller
public class JugadorController{
	
	
	JugadorDAO jugadorDAO = new JugadorDAO();
	EquipoDAO equipoDAO = new EquipoDAO();

	
	
	@GetMapping(value= {"","/"})
	String homejugadores(Model model) {
		
		
		
		//Salir a buscar a la BBDD
		
		ArrayList<Jugador> misJugadores = jugadorDAO.listarJugadorsJPA();
		ArrayList<Equipo> misEquipos = equipoDAO.listarEquiposJPA();

		model.addAttribute("listaJugadores", misJugadores);
		model.addAttribute("listaEquipos", misEquipos);
		model.addAttribute("jugadoraEditar", new Jugador());
		model.addAttribute("jugadorNuevo", new Jugador());
		
		return "jugadores";
	}
	
	
	@PostMapping("/edit/{id}")
	public String editarJugador(@PathVariable Integer id, @ModelAttribute("jugadoraEditar") Jugador JugadorEditado, BindingResult bidingresult) {
		
		Jugador jugadoraEditar = jugadorDAO.bucarPorIdJPA(id);
		
		jugadoraEditar.setNombre(JugadorEditado.getNombre());
		jugadoraEditar.setDorsal(JugadorEditado.getDorsal());
		jugadoraEditar.setEquipo(JugadorEditado.getEquipo());
		jugadoraEditar.setPosicion(JugadorEditado.getPosicion());


		
		jugadorDAO.modificarJugadorJPA(jugadoraEditar);
		
		
		return "redirect:/jugadores";
	}
	
	@PostMapping("/add")
	public String addJugador(@ModelAttribute("jugadorNuevo") Jugador JugadorNew, BindingResult bidingresult) {
		
		jugadorDAO.modificarJugadorJPA(JugadorNew);
		
		return "redirect:/jugadores";
	}
	
	
	@GetMapping(value= {"/{id}"})
	String idJugador(Model model, @PathVariable Integer id) {
		
		//model.addAttribute("JugadorAMostrar", jugadorDAO.bucarPorIdJPA(id));
		Jugador jugadoraMostrar = jugadorDAO.bucarPorIdJPA(id);
		model.addAttribute("jugadoraMostrar", jugadoraMostrar);
		
		return "jugador";
	}
	
	@GetMapping(value= {"/delete/{id}"})
	String deleteJugador(Model model, @PathVariable Integer id) {
		
		Jugador aeliminar = jugadorDAO.bucarPorIdJPA(id);
		jugadorDAO.eliminarJugadorJPA(aeliminar);
		return "redirect:/jugadores";
		
	}
}