package principal.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="leyendas")
public class Leyendas extends Jugador{
	
	
	

	public Leyendas() {
		super();
	}

	public Leyendas(String nombre, String posicion) {
		super(nombre, posicion);
	}
	
	 @ManyToMany(mappedBy = "leyendas")
	    private List<Equipo> equipos;

	public List<Equipo> getEquipos() {
		return equipos;
	}

	
	 
	 
	
}
