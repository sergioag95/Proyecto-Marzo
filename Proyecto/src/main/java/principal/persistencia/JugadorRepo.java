package principal.persistencia;

import java.util.Optional;   

import org.springframework.data.jpa.repository.JpaRepository;

import principal.modelo.Jugador;

public interface JugadorRepo extends JpaRepository<Jugador,Integer> {
	
	public Optional <Jugador> findByNombre(String nombre);

}