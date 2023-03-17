package principal.persistencia;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import principal.modelo.Usuario;
import principal.util.JPAUtil;


public class UsuarioDAO {
	

	public void insertarUsuarioJPA(Usuario Usuario) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(Usuario);
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
	
	
	public void modificarUsuarioJPA(Usuario Usuario) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(Usuario);
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
	
	
	public void eliminarUsuarioJPA(Usuario Usuario) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(Usuario) ? Usuario:em.merge(Usuario));
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
	
	
	public ArrayList<Usuario> listarUsuariosJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Usuario> misUsuarios = (ArrayList<Usuario>) em.createQuery("from Usuario").getResultList();	
			em.getTransaction().commit();
			return misUsuarios;
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
	
	public void imprimirUsuario(ArrayList<Usuario> misUsuarios) {
		System.out.println("El usuario buscado es:");
	 for (Usuario b : misUsuarios) {
		 b.toString();
	}	
	}
	
	
	
	public Usuario bucarPorIdJPA(int i) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Usuario b = (Usuario) em.find(Usuario.class, i);
			System.out.println("El Usuario buscado es "+b.getId());
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
