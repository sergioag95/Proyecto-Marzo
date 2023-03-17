package principal.servicio.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import principal.modelo.Jugador;

@Service
public interface JugadorService {

	public Jugador insertarJugador(Jugador a);
	public void modificarJugador(Jugador a);
	public void eliminarJugador(Jugador a);
	public List<Jugador> listarJugadors();
	public Jugador buscarJugadorPorIdJPA(Integer id);
	
}
