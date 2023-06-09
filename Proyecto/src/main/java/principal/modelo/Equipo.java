package principal.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany( mappedBy = "equipo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Jugador> jugadores = new ArrayList<>();;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Leyendas> leyendas;

	public Equipo() {

	}
	
	public Equipo(String ciudad, String nombre) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
	
	
	
	
}
