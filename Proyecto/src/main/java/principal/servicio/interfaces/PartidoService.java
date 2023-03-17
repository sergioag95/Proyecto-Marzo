package principal.servicio.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import principal.modelo.Partido;

@Service
public interface PartidoService {

	public Partido insertarPartido(Partido a);
	public void modificarPartido(Partido a);
	public void eliminarPartido(Partido a);
	public List<Partido> listarPartidos();
	public Partido buscarPartidoPorIdJPA(Integer id);
	
}
