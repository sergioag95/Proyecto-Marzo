package principal.controller;

import org.springframework.beans.factory.annotation.Autowired;   

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.modelo.Equipo;
import principal.modelo.Jugador;
import principal.modelo.Partido;
import principal.persistencia.EquipoRepo;
import principal.servicio.imp.EquipoServiceImpl;
import principal.servicio.imp.JugadorServiceImpl;
import principal.servicio.imp.PartidoServiceImpl;
import principal.servicio.imp.UsuarioServiceImpl;

@RestController

public class MainControllerSwagger {

	@GetMapping("/swagger")
	String home() {
		
		crearTablas();
		return "index";
		
	}
	
	@Autowired
	private EquipoRepo equipoRepo;
	
	@Autowired
	private EquipoServiceImpl equipoService;
	
	@Autowired
	private JugadorServiceImpl jugadorService;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private PartidoServiceImpl partidoService;
	
	
	public void crearTablas() {
		
	
		/*
		Usuario u1 = new Usuario();

		u1.setNombre("Sergio");
		
		usuarioService.insertarUsuario(u1);*/
		
		Equipo e1= new Equipo ("Golden State Warriors");
		Equipo e2= new Equipo ("Cleveland Cavaliers");
		
		// Creamos Jugadores

		Jugador j1 = new Jugador();
		
		j1.setNombre("Sergio");
		

		
		// Creamos Equipos
		

		
		j1.setEquipo(e1);
		
		Partido p1 = new Partido ();
		
		p1.setLocal(e1);
		p1.setVisitante(e2);
		p1.setLocal_res(125);
		p1.setVisitante_res(123);		
		
		equipoService.insertarEquipo(e1);
		equipoService.insertarEquipo(e2);
		
		jugadorService.insertarJugador(j1);
		
		partidoService.insertarPartido(p1);
		
		equipoRepo.save(e1);
		
		}
	
}
