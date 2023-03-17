package principal.persistencia;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import principal.modelo.Partido;
import principal.util.JPAUtil;


public class PartidoDAO {
	

	public void insertarPartidoJPA(Partido partido) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(partido);
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
	
	
	public void modificarPartidoJPA(Partido partido) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(partido);
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
	
	
	public void eliminarPartidoJPA(Partido partido) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(partido) ? partido:em.merge(partido));
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
	
	
	public ArrayList<Partido> listarPartidosJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Partido> misPartidos = (ArrayList<Partido>) em.createQuery("from Partido").getResultList();	
			em.getTransaction().commit();
			return misPartidos;
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
	
	public void imprimirPartido(ArrayList<Partido> misPartidos) {
		System.out.println("El partido buscado es:");
	 for (Partido b : misPartidos) {
		 b.toString();
	}	
	}
	
	
	
	public Partido bucarPorIdJPA(int i) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Partido b = (Partido) em.find(Partido.class, i);
			System.out.println("El partido buscado es "+b.getId());
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
