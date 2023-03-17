package principal.persistencia;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import principal.modelo.Equipo;
import principal.util.JPAUtil;


public class EquipoDAO {
	

	public void insertarEquipoJPA(Equipo equipo) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(equipo);
			em.getTransaction().commit();
		} 
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
		em.close();
		}
	
	}
	
	
	public void modificarEquipoJPA(Equipo equipo) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(equipo);
			em.getTransaction().commit();
		} 
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
		em.close();
		}
		
	}
	
	
	public void eliminarEquipoJPA(Equipo equipo) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(equipo) ? equipo:em.merge(equipo));
			em.getTransaction().commit();
		} 
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
		em.close();
		}
		
	}
	
	
	public ArrayList<Equipo> listarEquiposJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Equipo> misEquipos = (ArrayList<Equipo>) em.createQuery("from Equipo").getResultList();	
			em.getTransaction().commit();
			return misEquipos;
		} 
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
		em.close();
		}
		
		return null;
		
	}
	
	public void imprimirEquipo(ArrayList<Equipo> misEquipos) {
		System.out.println("El equipo buscado es:");
	 for (Equipo b : misEquipos) {
		 b.toString();
	}	
	}
	
	
	
	public Equipo bucarPorIdJPA(int i) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Equipo b = (Equipo) em.find(Equipo.class, i);
			System.out.println("El equipo buscado es "+b.getNombre());
			return b;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
		em.close();
		}
		
		return null;
		
	}
	
	
	
}
