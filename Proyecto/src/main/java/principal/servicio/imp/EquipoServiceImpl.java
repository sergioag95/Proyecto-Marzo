package principal.servicio.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.modelo.Equipo;
import principal.persistencia.EquipoRepo;
import principal.servicio.interfaces.EquipoService;


@Service
public class EquipoServiceImpl implements EquipoService{
	
	@Autowired
	private EquipoRepo equipoRepo;

	@Override
	public Equipo insertarEquipo(Equipo a) {
		equipoRepo.save(a);
		return null;
	}

	@Override
	public void modificarEquipo(Equipo a) {
		
		equipoRepo.save(a);
	}

	@Override
	public void eliminarEquipo(Equipo a) {
		
		equipoRepo.delete(a);
	}

	@Override
	public List<Equipo> listarEquipo() {
		
		return equipoRepo.findAll();
	}

	@Override
	public Equipo buscarEquipoPorIdJPA(Integer id) {
		
		return equipoRepo.findById(id).orElse(null);
	}

}
