package principal.persistencia;

import java.util.Optional;   

import org.springframework.data.jpa.repository.JpaRepository;

import principal.modelo.Equipo;

public interface EquipoRepo extends JpaRepository<Equipo,Integer> {
	
	public Optional <Equipo> findByNombre(String nombre);

}