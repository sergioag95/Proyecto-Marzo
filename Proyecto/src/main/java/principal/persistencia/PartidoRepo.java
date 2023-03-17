package principal.persistencia;

import java.util.Optional;   

import org.springframework.data.jpa.repository.JpaRepository;

import principal.modelo.Partido;

public interface PartidoRepo extends JpaRepository<Partido,Integer> {
	
	public Optional <Partido> findById(Integer id);

}