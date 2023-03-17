package principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import principal.modelo.Equipo;
import principal.modelo.Jugador;
import principal.modelo.Leyendas;
import principal.modelo.Partido;
import principal.persistencia.EquipoRepo;
import principal.servicio.imp.EquipoServiceImpl;
import principal.servicio.imp.JugadorServiceImpl;
import principal.servicio.imp.PartidoServiceImpl;
import principal.servicio.imp.UsuarioServiceImpl;

@Controller

public class MainController {

	@GetMapping("/")
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
	
	@Autowired
	private JugadorServiceImpl leyendaService;
	
	
	public void crearTablas() {
		

		Equipo e1 = new Equipo();
		
		e1.setNombre("Equipo Ejemplo 1");
		
		Equipo e2 = new Equipo();
		
		e2.setNombre("Equipo Ejemplo 2");
		
		equipoService.insertarEquipo(e1);
		equipoService.insertarEquipo(e2);
/*
		String[][] equipos = {{"Atlanta", "Hawks"},
                {"Boston", "Celtics"},
                {"Brooklyn", "Nets"},
                {"Charlotte", "Hornets"},
                {"Chicago", "Bulls"},
                {"Cleveland", "Cavaliers"},
                {"Dallas", "Mavericks"},
                {"Denver", "Nuggets"},
                {"Detroit", "Pistons"},
                {"Golden State", "Warriors"},
                {"Houston", "Rockets"},
                {"Indiana", "Pacers"},
                {"LA", "Clippers"},
                {"LA", "Lakers"},
                {"Memphis", "Grizzlies"},
                {"Miami", "Heat"},
                {"Milwaukee", "Bucks"},
                {"Minnesota", "Timberwolves"},
                {"New Orleans", "Pelicans"},
                {"New York", "Knicks"},
                {"Oklahoma City", "Thunder"},
                {"Orlando", "Magic"},
                {"Philadelphia", "76ers"},
                {"Phoenix", "Suns"},
                {"Portland", "Trail Blazers"},
                {"Sacramento", "Kings"},
                {"San Antonio", "Spurs"},
                {"Toronto", "Raptors"},
                {"Utah", "Jazz"},
                {"Washington", "Wizards"}};

for (int i = 0; i < equipos.length; i++) {
Equipo e = new Equipo(equipos[i][0], equipos[i][1]);
equipoService.insertarEquipo(e);
equipoRepo.save(e);

	for (int z = 0; z < 5; z++) {
	
		Jugador j = new Jugador();
		j.setNombre("Jugador Ejemplo");
		j.setEquipo(e);
		jugadorService.insertarJugador(j);
		
		
		Leyendas l = new Leyendas();
		l.setNombre("Leyenda Ejemplo");
		l.setEquipo(e);
		leyendaService.insertarJugador(l);		
	}


// Realizar acciones con cada instancia de la clase Equipo creada
}
	*/	
		// Creamos Jugadores

		
		Jugador j = new Jugador();
		j.setNombre("Jugador Ejemplo");
		j.setEquipo(e1);
		jugadorService.insertarJugador(j);
		
		
		Leyendas l = new Leyendas();
		l.setNombre("Leyenda Ejemplo");
		l.setEquipo(e1);
		leyendaService.insertarJugador(l);	
		
		Jugador j1 = new Jugador();
		j1.setNombre("Jugador Ejemplo");
		j1.setEquipo(e2);
		jugadorService.insertarJugador(j1);
		
		
		Leyendas l1 = new Leyendas();
		l1.setNombre("Leyenda Ejemplo");
		l1.setEquipo(e2);
		leyendaService.insertarJugador(l1);	


		
		// Creamos Equipos
		
		
		Partido p1 = new Partido ();
		
		p1.setLocal(e1);
		p1.setVisitante(e2);
		p1.setLocal_res(125);
		p1.setVisitante_res(123);		
		
	
		
		
		partidoService.insertarPartido(p1);
		
		equipoRepo.save(e1);
		
		}
	
}
