package principal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="partidos")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_equipoL",nullable=false)
	@JsonIgnore
	private Equipo local;
	
	@ManyToOne
	@JoinColumn(name = "id_equipoV" ,nullable=false)
	@JsonIgnore
	private Equipo visitante;
	
	@Column(name = "local_res" ,nullable=false)
	private int local_res;
	
	@Column(name = "visitante_res" ,nullable=false)
	private int visitante_res;

	public Partido() {
	}

	public Partido(Equipo local, int local_res, int visitante_res, Equipo visitante) {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public int getLocal_res() {
		return local_res;
	}

	public void setLocal_res(int local_res) {
		this.local_res = local_res;
	}

	public int getVisitante_res() {
		return visitante_res;
	}

	public void setVisitante_res(int visitante_res) {
		this.visitante_res = visitante_res;
	}

	@Override
	public String toString() {
		return "Partido nº"+id+" ["+visitante+" "+visitante_res+" - "+local_res+" "+local+"]";
	}
	
	
	
	
	
	
	
	
	
	
}
