package principal.persistencia;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import principal.modelo.Jugador;
import principal.util.JPAUtil;


public class JugadorDAO {
	

	public void insertarJugadorJPA(Jugador jugador) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(jugador);
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
	
	
	public void modificarJugadorJPA(Jugador jugador) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(jugador);
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
	
	
	public void eliminarJugadorJPA(Jugador jugador) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(jugador) ? jugador:em.merge(jugador));
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
	
	
	public ArrayList<Jugador> listarJugadorsJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Jugador> misJugadors = (ArrayList<Jugador>) em.createQuery("from Jugador").getResultList();	
			em.getTransaction().commit();
			return misJugadors;
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
	
	public void imprimirJugador(ArrayList<Jugador> misJugadors) {
		System.out.println("El jugador buscado es:");
	 for (Jugador b : misJugadors) {
		 b.toString();
	}	
	}
	
	
	
	public Jugador bucarPorIdJPA(int i) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Jugador b = (Jugador) em.find(Jugador.class, i);
			System.out.println("El jugador buscado es "+b.getNombre());
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
