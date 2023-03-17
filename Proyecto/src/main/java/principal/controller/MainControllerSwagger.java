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
	private PartidoServiceImpl partidoService;}
	
	
	
