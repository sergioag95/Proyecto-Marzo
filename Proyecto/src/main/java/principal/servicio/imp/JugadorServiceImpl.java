package principal.servicio.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.modelo.Jugador;
import principal.persistencia.JugadorRepo;
import principal.servicio.interfaces.JugadorService;


@Service
public class JugadorServiceImpl implements JugadorService{
	
	@Autowired
	private JugadorRepo jugadorRepo;

	@Override
	public Jugador insertarJugador(Jugador a) {
		jugadorRepo.save(a);
		return null;
	}

	@Override
	public void modificarJugador(Jugador a) {
		
		jugadorRepo.save(a);
	}

	@Override
	public void eliminarJugador(Jugador a) {
		
		jugadorRepo.delete(a);
	}

	@Override
	public List<Jugador> listarJugadors() {
		
		return jugadorRepo.findAll();
	}

	@Override
	public Jugador buscarJugadorPorIdJPA(Integer id) {
		
		return jugadorRepo.findById(id).orElse(null);
	}

}
