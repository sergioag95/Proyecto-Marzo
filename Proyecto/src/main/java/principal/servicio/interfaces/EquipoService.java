package principal.servicio.interfaces;

import java.util.List; 

import org.springframework.stereotype.Service;

import principal.modelo.Equipo;

@Service
public interface EquipoService {

	public Equipo insertarEquipo(Equipo a);
	public void modificarEquipo(Equipo a);
	public void eliminarEquipo(Equipo a);
	public List<Equipo> listarEquipo();
	public Equipo buscarEquipoPorIdJPA(Integer id);
	
}
