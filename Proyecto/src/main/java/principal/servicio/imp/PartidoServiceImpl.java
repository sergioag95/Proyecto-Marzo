package principal.servicio.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.modelo.Partido;
import principal.persistencia.PartidoRepo;
import principal.servicio.interfaces.PartidoService;


@Service
public class PartidoServiceImpl implements PartidoService{
	
	@Autowired
	private PartidoRepo alumnoRepo;

	@Override
	public Partido insertarPartido(Partido a) {
		alumnoRepo.save(a);
		return null;
	}

	@Override
	public void modificarPartido(Partido a) {
		
		alumnoRepo.save(a);
	}

	@Override
	public void eliminarPartido(Partido a) {
		
		alumnoRepo.delete(a);
	}

	@Override
	public List<Partido> listarPartidos() {
		
		return alumnoRepo.findAll();
	}

	@Override
	public Partido buscarPartidoPorIdJPA(Integer id) {
		
		return alumnoRepo.findById(id).orElse(null);
	}

}
